package com.library.domain.user;

import com.library.configuration.security.Token;
import com.library.configuration.security.TokenService;
import com.library.domain.user.dto.*;
import com.library.domain.user.enums.StatusUser;
import com.library.infrastructure.exception.NoAuthorizationException;
import com.library.infrastructure.exception.RecordNotFoundException;
import com.library.services.email.Email;
import com.library.services.email.EmailService;
import com.library.services.resetpassword.TokenResetService;
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
    private final TokenResetService tokenResetService;
    private final EmailService emailService;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       TokenService tokenService,
                       AuthenticationManager authenticationManager,
                       UserMapper userMapper, TokenResetService tokenResetService, EmailService emailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.userMapper = userMapper;
        this.tokenResetService = tokenResetService;
        this.emailService = emailService;
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

    @Transactional
    public String updatePassword(UserUpdatePasswordDTO data){
        if(validateUserDataUpdate(data.id())){
            var user = userRepository.getReferenceById(data.id());
            user.setPassword(passwordEncoder.encode(data.password()));
            return "Password update success";
        }
        throw new NoAuthorizationException("No authorization for this action");
    }

    public void forgotPassword(UserForgotPasswordDTO data) throws Exception {
        UserDomain userDomain = userRepository.findByEmail(data.email())
                                              .orElseThrow(() -> new RecordNotFoundException(data.email()));

        String token = tokenResetService.generateToken(userDomain);

        String subject = "Change Password";
        String from = "riquelmemontijo@gmail.com";
        String to = data.email();
        String content = getTextForEmailResetPassword(userDomain, token);

        var email = new Email(subject, from, to, content);

        emailService.sendMimeMail(email, content);
    }

    public void delete(UUID id){
        var student = userRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        userRepository.deleteById(student.getId());
    }

    public void forgotPasswordUpdate(String password, String token) throws Exception {
        tokenResetService.updatePassword(password, token);
    }

    private String getTextForEmailResetPassword(UserDomain userDomain, String token){
        return """
                  <!DOCTYPE html>
                  <html lang="pt-br">
                     <head>
                      <meta charset="UTF-8">
                      <meta http-equiv="X-UA-Compatible" content="IE=edge">
                      <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>Email Reset Senha</title>
                        <style type="text/css">
                           * { font-family: 'Inter', sans-serif; background-color: #f4f4f5; } -->
                           body { display: flex; flex-direction: column; }
                           a { color: #007a12; text-decoration: none;}
                           .center { text-align: center; }
                        </style>
                     </head>
                     <body>
                        <div class="center">
                           <h2>Hello, %s! </h2>
                           <p>
                              This is an email to update your password.<br/>
                              click on the link below to change the password.
                           </p>
                           <br/>
                           <h2><a href="%s">Change Password</a></h2>
                        </div>
                     </body>
                  </html>
               """.formatted(userDomain.getName().split(" ")[0], "http://localhost/forgot-password/" + token);
    }

    private boolean validateUserDataUpdate(UUID idUserUpdate){
        var idAuthenticatedUser = SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal()
                .toString()
                .replace("Optional[", "")
                .replace("]", "");

        return idAuthenticatedUser.equals(idUserUpdate.toString());
    }

    private List<String> extractRoles(String roles) {
        return Arrays.stream(roles.replace("[", "")
                .replace("]", "")
                .replace("ROLE_", "")
                .split(", ")).toList();
    }

}
