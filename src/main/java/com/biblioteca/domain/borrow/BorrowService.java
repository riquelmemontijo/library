package com.biblioteca.domain.borrow;

import com.biblioteca.domain.book.BookRepository;
import com.biblioteca.domain.book.BookService;
import com.biblioteca.domain.borrow.dto.BorrowFormDTO;
import com.biblioteca.domain.borrow.dto.BorrowInfoDTO;
import com.biblioteca.domain.borrow.dto.BorrowReturnDTO;
import com.biblioteca.domain.borrow.rules.ValidateBorrow;
import com.biblioteca.domain.debit.StudentDebitService;
import com.biblioteca.domain.student.StudentRepository;
import com.biblioteca.infrastructure.exception.BusinessRulesException;
import com.biblioteca.infrastructure.exception.RecordNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class BorrowService {

    private final BorrowRepository borrowRepository;
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;
    private final BorrowMapper borrowMapper;
    private final StudentDebitService studentDebitService;
    private final BookService bookService;
    private final List<ValidateBorrow> validations;

    public BorrowService(BorrowRepository borrowRepository, StudentRepository studentRepository, BookRepository bookRepository, BorrowMapper borrowMapper, StudentDebitService studentDebitService, BookService bookService, List<ValidateBorrow> validations) {
        this.borrowRepository = borrowRepository;
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
        this.borrowMapper = borrowMapper;
        this.studentDebitService = studentDebitService;
        this.bookService = bookService;
        this.validations = validations;
    }

    public BorrowInfoDTO getById(UUID id){
        return borrowRepository.findById(id)
                .map(borrowMapper::borrowToBorrowInfoDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Page<BorrowInfoDTO> getAll(Pageable pageable){
        return borrowRepository.findAll(pageable)
                .map(borrowMapper::borrowToBorrowInfoDTO);
    }

    @Transactional
    public void delete(UUID id){
        var borrow = borrowRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        borrowRepository.delete(borrow);
    }

    @Transactional
    public BorrowInfoDTO makeBorrow(BorrowFormDTO borrowFormDTO){

        var borrow = borrowMapper.borrowFormDTOtoBorrow(borrowFormDTO);
        borrow.setDueDate(borrow.getBorrowDate().plusDays(7));

        var student = studentRepository.findById(borrowFormDTO.student().id())
                .orElseThrow(() -> new RecordNotFoundException(borrowFormDTO.student().id()));

        var books = borrowFormDTO.books()
                                 .stream()
                                 .map(book -> bookRepository.findById(book.id())
                                         .orElseThrow(() -> new RecordNotFoundException(book.id())))
                                 .toList();

        borrow.setStudent(student);
        borrow.setBooks(books);
        borrow.setIsFinished(false);
        validations.forEach(validation -> validation.validate(borrow));
        borrowRepository.save(borrow);
        bookService.decreaseStock(borrow.getBooks());
        return borrowMapper.borrowToBorrowInfoDTO(borrow);
    }

    @Transactional
    public BorrowInfoDTO returnBorrow(BorrowReturnDTO borrowReturnDTO){
        var borrow = borrowRepository.findById(borrowReturnDTO.id())
                .orElseThrow(() -> new RecordNotFoundException(borrowReturnDTO.id()));

        if(borrow.getIsFinished()){
           throw new BusinessRulesException("This borrow already been finished");
        }

        borrow.setReturnDate(borrowReturnDTO.returnDate());
        borrow.setIsFinished(true);
        bookService.addStock(borrow.getBooks());

        if(borrow.getDueDate().isBefore(borrow.getReturnDate())){
            studentDebitService.generateStudentDebit(borrow);
        }

        return borrowMapper.borrowToBorrowInfoDTO(borrow);
    }
}