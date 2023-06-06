package com.biblioteca.domain.gender;

import com.biblioteca.domain.gender.dto.GenderFormDTO;
import com.biblioteca.domain.gender.dto.GenderInfoDTO;
import com.biblioteca.domain.gender.dto.GenderUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/gender")
public class GenderController {

    private final GenderService genderService;

    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody GenderFormDTO data, UriComponentsBuilder uriBuilder){
        var gender = genderService.create(data);
        var uri = uriBuilder.path("/gender/{id}")
                            .buildAndExpand(gender.id())
                            .toUri();
        return ResponseEntity.created(uri).body(gender);
    }

    @GetMapping
    public ResponseEntity<Page<GenderInfoDTO>> getAll(@PageableDefault(size = 20, sort = {"id"}) Pageable pageable){
        return ResponseEntity.ok(genderService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenderInfoDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(genderService.getById(id));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody GenderUpdateDTO data){
        return ResponseEntity.ok(genderService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        genderService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
