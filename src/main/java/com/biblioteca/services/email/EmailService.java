package com.biblioteca.services.email;

import com.biblioteca.services.email.dto.EmailModelDTO;
import jakarta.mail.Message;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendSimpleMail(EmailModelDTO emailDTO){
        var mensagem = new SimpleMailMessage();
        mensagem.setSubject(emailDTO.subject());
        mensagem.setFrom(emailDTO.from());
        mensagem.setTo(emailDTO.to());
        mensagem.setText(emailDTO.content());
        mailSender.send(mensagem);
    }

    public void sendMimeEmail(EmailModelDTO emailDTO){
        mailSender.send(mimeMessage -> {
            mimeMessage.setSubject(emailDTO.subject());
            mimeMessage.setFrom(emailDTO.from());
            mimeMessage.setRecipients(Message.RecipientType.TO, emailDTO.to());
            mimeMessage.setContent(emailDTO.content(), "text/html; charset=utf-8");
        });
    }

}
