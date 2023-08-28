package com.library.domain.book;

import com.library.domain.book.dto.BookFormDTO;
import com.library.domain.book.dto.BookInfoDTO;
import com.library.domain.book.dto.BookUpdateDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/book")
@SecurityRequirement(name = "bearer-key")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

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
