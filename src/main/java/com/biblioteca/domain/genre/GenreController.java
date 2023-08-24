package com.biblioteca.domain.genre;

import com.biblioteca.domain.genre.dto.GenreFormDTO;
import com.biblioteca.domain.genre.dto.GenreInfoDTO;
import com.biblioteca.domain.genre.dto.GenreUpdateDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/gender")
@SecurityRequirement(name = "bearer-key")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody GenreFormDTO data, UriComponentsBuilder uriBuilder){
        var gender = genreService.create(data);
        var uri = uriBuilder.path("/gender/{id}")
                            .buildAndExpand(gender.id())
                            .toUri();
        return ResponseEntity.created(uri).body(gender);
    }

    @GetMapping
    public ResponseEntity<Page<GenreInfoDTO>> getAll(@PageableDefault(size = 20, sort = {"id"}) Pageable pageable){
        return ResponseEntity.ok(genreService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreInfoDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(genreService.getById(id));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody GenreUpdateDTO data){
        return ResponseEntity.ok(genreService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        genreService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
