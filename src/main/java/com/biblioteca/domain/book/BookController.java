package com.biblioteca.domain.book;

import com.biblioteca.domain.book.dto.BookFormDTO;
import com.biblioteca.domain.gender.Gender;
import com.biblioteca.domain.gender.dto.GenderFormDTO;
import com.biblioteca.domain.gender.dto.GenderInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/book")
public class BookController {

//    @Autowired
//    private BookRepository repository;

//    @PostMapping
//    @Transactional
//    public ResponseEntity create(@RequestBody BookFormDTO data, UriComponentsBuilder uriBuilder){
//        var gender = new Gender(data);
//        repository.save(gender);
//        var uri = uriBuilder.path("/gender/{id}").buildAndExpand(gender.getId()).toUri();
//        return ResponseEntity.created(uri).body(new GenderInfoDTO(gender));
//    }

}
