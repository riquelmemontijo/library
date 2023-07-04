package com.biblioteca.domain.user;

import com.biblioteca.configuration.security.Token;
import com.biblioteca.configuration.security.TokenService;
import com.biblioteca.domain.student.dto.StudentInfoDTO;
import com.biblioteca.domain.student.dto.StudentUpdateDTO;
import com.biblioteca.domain.user.dto.UserFormDTO;
import com.biblioteca.domain.user.dto.UserInfoDTO;
import com.biblioteca.domain.user.dto.UserLoginDTO;
import com.biblioteca.domain.user.dto.UserUpdateDTO;
import com.biblioteca.domain.user.enums.StatusUser;
import com.biblioteca.infrastructure.exception.NoAuthorizationException;
import com.biblioteca.infrastructure.exception.RecordNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       TokenService tokenService,
                       AuthenticationManager authenticationManager,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.userMapper = userMapper;
    }

    public Token login(UserLoginDTO data){
        var tokenAuthentication = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var authentication = authenticationManager.authenticate(tokenAuthentication);
        var tokenResponse = tokenService.generateToken((User) authentication.getPrincipal());
        var roles = extractRoles(authentication.getAuthorities().toString());
        return new Token(tokenResponse, roles);
    }

    @Transactional
    public UserInfoDTO createUser(UserFormDTO form){
        var user = userMapper.userFormDTOtoUser(form);
        var encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        user.setStatus(StatusUser.ACTIVE);
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
        return userMapper.userToUserInfoDTO(user);
    }

    public Page<UserInfoDTO> getAll(Pageable pageable){
        return userRepository.findAll(pageable)
                .map(userMapper::userToUserInfoDTO);
    }

    public UserInfoDTO getById(UUID id){
        return userRepository.findById(id)
                .map(userMapper::userToUserInfoDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Transactional
    public UserInfoDTO update(UserUpdateDTO userUpdateDTO){
        var user = userRepository.findById(userUpdateDTO.id())
                .orElseThrow(() -> new RecordNotFoundException(userUpdateDTO.id()));
        if(validateUserDataUpdate(userUpdateDTO.id())){
            user.update(userUpdateDTO);
            return userMapper.userToUserInfoDTO(user);
        }
        throw new NoAuthorizationException("No authorization for this action.");

    }

    public void delete(UUID id){
        var student = userRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        userRepository.deleteById(student.getId());
    }

    public boolean validateUserDataUpdate(UUID idUserUpdate){
        System.out.println(SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal()
                .toString());
        var idAuthenticatedUser = SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal()
                .toString()
                .replace("Optional[", "")
                .replace("]", "");
        System.out.println(idAuthenticatedUser);
        System.out.println(idUserUpdate);

        return idAuthenticatedUser.equals(idUserUpdate.toString());
    }

    private List<String> extractRoles(String roles) {
        return Arrays.stream(roles.replace("[", "")
                .replace("]", "")
                .replace("ROLE_", "")
                .split(", ")).toList();
    }

}
