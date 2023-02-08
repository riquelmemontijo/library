package com.biblioteca.domain.gender;

import com.biblioteca.domain.gender.dto.GenderFormDTO;
import com.biblioteca.domain.gender.dto.GenderInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.UUID;

@RestController
@RequestMapping("/gender")
public class GenderController {

    @Autowired
    private GenderRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody GenderFormDTO data, UriComponentsBuilder uriBuilder){
        var gender = new Gender(data);
        repository.save(gender);
        var uri = uriBuilder.path("/gender/{id}").buildAndExpand(gender.getId()).toUri();
        return ResponseEntity.created(uri).body(new GenderInfoDTO(gender));
    }

    @GetMapping
    public ResponseEntity<Page<GenderInfoDTO>> getAll(@PageableDefault(size = 20, sort = {"id"})
                                                      Pageable pageable){
        var page = repository.findAll(pageable).map(GenderInfoDTO::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GenderInfoDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(new GenderInfoDTO(repository.findById(id).get()));
    }

}
