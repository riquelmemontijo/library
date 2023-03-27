package com.biblioteca.domain.book;

import com.biblioteca.domain.book.dto.BookFormDTO;
import com.biblioteca.domain.book.dto.BookInfoDTO;
import com.biblioteca.domain.book.dto.BookUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity create(@RequestBody BookFormDTO data, UriComponentsBuilder uriBuilder){
        System.out.println("Controller: " + data);
        var book = bookService.create(data);
        var uri = uriBuilder.path("/gender/{id}")
                .buildAndExpand(book.id())
                .toUri();
        return ResponseEntity.created(uri).body(book);
    }

    @GetMapping
    public ResponseEntity<Page<BookInfoDTO>> getAll(@PageableDefault(size = 20, sort = {"id"}) Pageable pageable){
        return ResponseEntity.ok(bookService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookInfoDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(bookService.getById(id));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody BookUpdateDTO data){
        return ResponseEntity.ok(bookService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
