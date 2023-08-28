package com.library.domain.book;

import com.library.domain.book.dto.BookFormDTO;
import com.library.domain.book.dto.BookInfoDTO;
import com.library.domain.book.dto.BookUpdateDTO;
import com.library.infrastructure.exception.RecordNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public BookInfoDTO getById(UUID id){
        return bookRepository.findById(id)
                .map(bookMapper::bookToBookInfoDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Page<BookInfoDTO> getAll(Pageable pageable){
        return bookRepository.findAll(pageable)
                .map(bookMapper::bookToBookInfoDTO);
    }

    @Transactional
    public BookInfoDTO create(BookFormDTO data){
        var book = bookRepository.save(bookMapper.bookFormDTOtoBook(data));
        return bookMapper.bookToBookInfoDTO(book);
    }

    @Transactional
    public BookInfoDTO update(BookUpdateDTO bookUpdateDTO){

        var book = bookRepository.findById(bookUpdateDTO.id())
                .orElseThrow(() -> new RecordNotFoundException(bookUpdateDTO.id()));

        book.update(bookUpdateDTO);

        return bookMapper.bookToBookInfoDTO(book);
    }

    @Transactional
    public void delete(UUID id){
        var book = bookRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        bookRepository.delete(book);
    }

    @Transactional
    public void decreaseStock(List<Book> books){
        bookRepository.decreaseStock(books);
    }

    @Transactional
    public void addStock(List<Book> books){
        bookRepository.addStock(books);
    }

}
