package com.library.domain.student;

import com.library.domain.student.dto.StudentFormDTO;
import com.library.domain.student.dto.StudentInfoDTO;
import com.library.domain.student.dto.StudentUpdateDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/student")
@SecurityRequirement(name = "bearer-key")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody StudentFormDTO data, UriComponentsBuilder uriBuilder){
        var student = studentService.create(data);
        var uri = uriBuilder.path("/student/{id}")
                .buildAndExpand(student.id())
                .toUri();
        return ResponseEntity.created(uri).body(student);
    }

    @GetMapping
    public ResponseEntity<Page<StudentInfoDTO>> getAll(@PageableDefault(size = 20, sort = {"id"}) Pageable pageable){
        return ResponseEntity.ok(studentService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentInfoDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(studentService.getById(id));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody StudentUpdateDTO data){
        return ResponseEntity.ok(studentService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
