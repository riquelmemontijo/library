package com.library.domain.user;

import com.library.domain.user.dto.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity createUser(@RequestBody @Valid UserFormDTO form){
        return ResponseEntity.ok(userService.createUser(form));
    }

    @GetMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Page<UserInfoDTO>> getAll(@PageableDefault(size = 20, sort = {"id"}) Pageable pageable){
        return ResponseEntity.ok(userService.getAll(pageable));
    }

    @GetMapping("/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<UserInfoDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @PutMapping("/update-data")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity update(@RequestBody UserUpdateDTO data){
        return ResponseEntity.ok(userService.update(data));
    }

    @PutMapping("/update-password")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity updatePassword(@RequestBody UserUpdatePasswordDTO data){
        return ResponseEntity.ok(userService.updatePassword(data));
    }

    @PostMapping("/forgot-password")
    public void forgotPassword(@RequestBody UserForgotPasswordDTO data) throws Exception {
        userService.forgotPassword(data);
    }

    @PostMapping("/forgot-password/{token}")
    public void forgotPasswordUpdate(@PathVariable String token,
                                     @RequestBody UserForgotPasswordUpdateDTO data) throws Exception {
        System.out.println(token);
        userService.forgotPasswordUpdate(data.password(), token);
    }

    @DeleteMapping("/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity delete(@PathVariable UUID id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
