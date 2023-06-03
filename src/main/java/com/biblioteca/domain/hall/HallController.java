package com.biblioteca.domain.hall;

import com.biblioteca.domain.hall.dto.HallFormDTO;
import com.biblioteca.domain.hall.dto.HallInfoDTO;
import com.biblioteca.domain.hall.dto.HallUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/hall")
public class HallController {

    @Autowired
    private HallService hallService;

    @PostMapping
    public ResponseEntity create(@RequestBody HallFormDTO data, UriComponentsBuilder uriBuilder){
        var hall = hallService.create(data);
        var uri = uriBuilder.path("/hall/{id}")
                .buildAndExpand(hall.id())
                .toUri();
        return ResponseEntity.created(uri).body(hall);
    }

    @GetMapping
    public ResponseEntity<Page<HallInfoDTO>> getAll(@PageableDefault(size = 20, sort = {"id"}) Pageable pageable){
        return ResponseEntity.ok(hallService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HallInfoDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(hallService.getById(id));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody HallUpdateDTO data){
        return ResponseEntity.ok(hallService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        hallService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
