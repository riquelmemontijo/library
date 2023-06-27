package com.biblioteca.tasks;

import com.biblioteca.domain.borrow.BorrowRepository;
import com.biblioteca.services.email.EmailService;
import com.biblioteca.services.email.dto.EmailModelDTO;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SendMailToNotifyBorrowExpiration {

    private final EmailService emailService;
    private final BorrowRepository borrowRepository;

    public SendMailToNotifyBorrowExpiration(EmailService emailService, BorrowRepository borrowRepository) {
        this.emailService = emailService;
        this.borrowRepository = borrowRepository;
    }

    @Scheduled(fixedDelay = 10000L)
    private void getStudentsWithDelay(){
        var borrows = borrowRepository.findBorrowDueToday();
        borrows.ifPresent(n -> {
            n.forEach(record -> {
                emailService.sendMimeEmail(new EmailModelDTO(""));
            });
        });
    }

}
