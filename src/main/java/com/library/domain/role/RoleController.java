package com.library.domain.role;

import com.library.domain.role.dto.RoleInfoDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@RequestMapping("/role")
@SecurityRequirement(name = "bearer-key")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<Page<RoleInfoDTO>> getAll(@PageableDefault(size = 20, sort = {"id"}) Pageable pageable){
        return ResponseEntity.ok(roleService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleInfoDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(roleService.getById(id));
    }

}
