package com.library.domain.debit;

import com.library.domain.debit.dto.StudentDebitInfoDTO;
import com.library.domain.debit.dto.StudentDebitPaidDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/student-debit")
@SecurityRequirement(name = "bearer-key")
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

    @PostMapping
    public ResponseEntity payDebit(@RequestBody StudentDebitPaidDTO data){
        return ResponseEntity.ok(service.payDebit(data));
    }

}
