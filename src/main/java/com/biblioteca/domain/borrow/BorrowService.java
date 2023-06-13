package com.biblioteca.domain.borrow;

import com.biblioteca.domain.book.BookService;
import com.biblioteca.domain.borrow.dto.BorrowFormDTO;
import com.biblioteca.domain.borrow.dto.BorrowInfoDTO;
import com.biblioteca.domain.borrow.dto.BorrowReturnDTO;
import com.biblioteca.domain.borrow.dto.BorrowUpdateDTO;
import com.biblioteca.domain.borrow.rules.ValidateBorrow;
import com.biblioteca.domain.debit.StudentDebitService;
import com.biblioteca.infrastructure.exception.RecordNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BorrowService {

    private final BorrowRepository borrowRepository;
    private final BorrowMapper borrowMapper;
    private final StudentDebitService studentDebitService;
    private final BookService bookService;
    private final List<ValidateBorrow> validations;

    public BorrowService(BorrowRepository borrowRepository, BorrowMapper borrowMapper, StudentDebitService studentDebitService, BookService bookService, List<ValidateBorrow> validations) {
        this.borrowRepository = borrowRepository;
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
    public BorrowInfoDTO create(BorrowFormDTO data){
        var borrow = borrowRepository.save(borrowMapper.borrowFormDTOtoBorrow(data));
        return borrowMapper.borrowToBorrowInfoDTO(borrow);
    }

    @Transactional
    public BorrowInfoDTO update(BorrowUpdateDTO borrowUpdateDTO){

        var borrow = borrowRepository.findById(borrowUpdateDTO.id())
                .orElseThrow(() -> new RecordNotFoundException(borrowUpdateDTO.id()));

        borrow.update(borrowUpdateDTO);

        return borrowMapper.borrowToBorrowInfoDTO(borrow);
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
        validations.forEach(validation -> validation.validate(borrow));
        borrowRepository.save(borrow);
        bookService.decreaseStock(borrow.getBooks());
        return borrowMapper.borrowToBorrowInfoDTO(borrow);
    }

    @Transactional
    public BorrowInfoDTO returnBorrow(BorrowReturnDTO borrowReturnDTO){
        var borrow = borrowRepository.findById(borrowReturnDTO.id())
                .orElseThrow(() -> new RecordNotFoundException(borrowReturnDTO.id()));
        borrow.setReturnDate(borrowReturnDTO.returnDate());
        bookService.addStock(borrow.getBooks());
        if(borrow.getDueDate().isBefore(borrow.getReturnDate())){
            studentDebitService.generateStudentDebit(borrow);
        }
        return borrowMapper.borrowToBorrowInfoDTO(borrow);
    }
}
