package com.biblioteca.domain.bookcase;

import com.biblioteca.domain.bookcase.dto.BookcaseFormDTO;
import com.biblioteca.domain.bookcase.dto.BookcaseInfoDTO;
import com.biblioteca.domain.bookcase.dto.BookcaseUpdateDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/bookcase")
@SecurityRequirement(name = "bearer-key")
public class BookcaseController {

    private final BookcaseService bookcaseService;

    public BookcaseController(BookcaseService bookcaseService) {
        this.bookcaseService = bookcaseService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody BookcaseFormDTO data, UriComponentsBuilder uriBuilder){
        var bookcase = bookcaseService.create(data);
        var uri = uriBuilder.path("/bookcase/{id}")
                .buildAndExpand(bookcase.id())
                .toUri();
        return ResponseEntity.created(uri).body(bookcase);
    }

    @GetMapping
    public ResponseEntity<Page<BookcaseInfoDTO>> getAll(@PageableDefault(size = 20, sort = {"id"}) Pageable pageable){
        return ResponseEntity.ok(bookcaseService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookcaseInfoDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(bookcaseService.getById(id));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody BookcaseUpdateDTO data){
        return ResponseEntity.ok(bookcaseService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        bookcaseService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
