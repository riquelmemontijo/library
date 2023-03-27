package com.biblioteca.domain.book;

import com.biblioteca.domain.book.dto.BookFormDTO;
import com.biblioteca.domain.book.dto.BookInfoDTO;
import com.biblioteca.domain.book.dto.BookUpdateDTO;
import com.biblioteca.infrastructure.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

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
        System.out.println("Service: " + data);
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

    public void delete(UUID id){
        var book = bookRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        bookRepository.delete(book);
    }

}