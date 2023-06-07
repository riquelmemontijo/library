package com.biblioteca.domain.debit;

import com.biblioteca.domain.debit.dto.StudentDebitInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/student-debit")
public class StudentDebitController {

    private final StudentDebitService service;

    public StudentDebitController(StudentDebitService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<StudentDebitInfoDTO>> getAll(@PageableDefault(size = 20, sort = {"id"}) Pageable pageable){
        return ResponseEntity.ok(service.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDebitInfoDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(service.getById(id));
    }

}
