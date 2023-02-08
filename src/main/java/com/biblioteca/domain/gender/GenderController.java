package com.biblioteca.domain.gender;

import com.biblioteca.domain.gender.dto.GenderFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;

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
        return ResponseEntity.created(uri).body(gender);
    }

}
