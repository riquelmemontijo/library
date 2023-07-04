package com.biblioteca.domain.user;

import com.biblioteca.domain.user.dto.UserFormDTO;
import com.biblioteca.domain.user.dto.UserInfoDTO;
import com.biblioteca.domain.user.dto.UserLoginDTO;
import com.biblioteca.domain.user.dto.UserUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UserLoginDTO data){
        return ResponseEntity.ok(userService.login(data));
    }

    @PostMapping("/create-user")
    public ResponseEntity createUser(@RequestBody @Valid UserFormDTO form){
        return ResponseEntity.ok(userService.createUser(form));
    }

    @GetMapping
    public ResponseEntity<Page<UserInfoDTO>> getAll(@PageableDefault(size = 20, sort = {"id"}) Pageable pageable){
        return ResponseEntity.ok(userService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInfoDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody UserUpdateDTO data){
        return ResponseEntity.ok(userService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
