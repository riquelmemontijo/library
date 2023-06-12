package com.biblioteca.domain.author;

import com.biblioteca.domain.author.dto.AuthorFormDTO;
import com.biblioteca.domain.author.dto.AuthorInfoDTO;
import com.biblioteca.domain.author.dto.AuthorUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody AuthorFormDTO data, UriComponentsBuilder uriBuilder){
        var author = authorService.create(data);
        var uri = uriBuilder.path("/author/{id}")
                .buildAndExpand(author.id())
                .toUri();
        return ResponseEntity.created(uri).body(author);
    }

    @GetMapping
    public ResponseEntity<Page<AuthorInfoDTO>> getAll(@PageableDefault(size = 20, sort = {"id"}) Pageable pageable){
        return ResponseEntity.ok(authorService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorInfoDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(authorService.getById(id));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody AuthorUpdateDTO data){
        return ResponseEntity.ok(authorService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
