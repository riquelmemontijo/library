package com.library.services.email;

import com.library.services.email.dto.EmailInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log-email")
public class EmailController {

    private final EmailRepository emailRepository;
    private final EmailMapper emailMapper;

    public EmailController(EmailRepository emailRepository, EmailMapper emailMapper) {
        this.emailRepository = emailRepository;
        this.emailMapper = emailMapper;
    }

    @GetMapping
    public ResponseEntity<Page<EmailInfoDTO>> getEmails(@PageableDefault(size = 20, sort = {"id"}) Pageable pageable){
        var emails =  emailRepository.findAll(pageable).map(emailMapper::emailToEmailInfoDTO);
        return ResponseEntity.ok(emails);
    }

}
