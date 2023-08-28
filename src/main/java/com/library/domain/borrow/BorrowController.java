package com.library.domain.borrow;

import com.library.domain.borrow.dto.BorrowFormDTO;
import com.library.domain.borrow.dto.BorrowInfoDTO;
import com.library.domain.borrow.dto.BorrowReturnDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/borrow")
@SecurityRequirement(name = "bearer-key")
public class BorrowController {

    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping
    public ResponseEntity makeBorrow(@RequestBody BorrowFormDTO data, UriComponentsBuilder uriBuilder){
        var borrow = borrowService.makeBorrow(data);
        var uri = uriBuilder.path("/borrow/{id}")
                .buildAndExpand(borrow.id())
                .toUri();
        return ResponseEntity.created(uri).body(borrow);
    }

    @PostMapping("/return")
    public ResponseEntity returnBorrow(@RequestBody BorrowReturnDTO data){
        return ResponseEntity.ok(borrowService.returnBorrow(data));
    }

    @GetMapping
    public ResponseEntity<Page<BorrowInfoDTO>> getAll(@PageableDefault(size = 20, sort = {"id"}) Pageable pageable){
        return ResponseEntity.ok(borrowService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowInfoDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(borrowService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        borrowService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
