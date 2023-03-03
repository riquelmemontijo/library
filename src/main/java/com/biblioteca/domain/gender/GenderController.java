package com.biblioteca.domain.gender;

import com.biblioteca.domain.gender.dto.GenderFormDTO;
import com.biblioteca.domain.gender.dto.GenderInfoDTO;
import com.biblioteca.domain.gender.dto.GenderUpdateDTO;
import com.biblioteca.infrastructure.exception.RecordNotFoundException;
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

    @Autowired
    private GenderMapper genderMapper;

    @Autowired
    private GenderService genderService;

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
    @Transactional
    public ResponseEntity update(@RequestBody GenderUpdateDTO data){
        var gender = repository.findById(data.id())
                               .map(recordFound -> genderMapper.genderUpdateDTOtoGender(data))
                               .orElseThrow(() -> new RecordNotFoundException(data.id()));
        return ResponseEntity.ok(genderMapper.genderToGenderInfoDTO(gender));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable UUID id){
        var gender = repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        repository.delete(gender);
        return ResponseEntity.noContent().build();
    }

}
