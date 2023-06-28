package com.biblioteca.services.email;

import jakarta.transaction.Transactional;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final EmailRepository emailRepository;

    public EmailService(JavaMailSender mailSender, EmailRepository emailRepository) {
        this.mailSender = mailSender;
        this.emailRepository = emailRepository;
    }

    @Transactional
    public void sendSimpleMail(Email email){

        var message = new SimpleMailMessage();
        email.setSendDate(LocalDateTime.now());
        message.setSubject(email.getSubject());
        message.setFrom(email.getFrom());
        message.setTo(email.getTo());
        message.setText(email.getContent());

        try{
            mailSender.send(message);
            email.setStatus(StatusEmail.SENT);
            emailRepository.save(email);
        }catch (MailException mailException){
            email.setStatus(StatusEmail.ERROR);
            emailRepository.save(email);
        }

    }

}
