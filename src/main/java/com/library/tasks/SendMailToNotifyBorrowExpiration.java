package com.library.tasks;

import com.library.domain.borrow.BorrowRepository;
import com.library.services.email.Email;
import com.library.services.email.EmailService;
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

    @Scheduled(cron = "0 0 6 * * *")
    private void getStudentsWithDelay(){
        var borrows = borrowRepository.findBorrowDueToday();
        borrows.ifPresent(n -> n.forEach(record ->
            emailService.sendSimpleMail(new Email(getSubject(),
                                             "riquelmemontijo@gmail.com",
                                                  record.email(),
                                                  getContent(record.name())))));
    }

    private String getContent(String name){
        return """
                  Hello, %s!
                  Your borrow expires tomorrow!
                  Plan ahead so as not to delay the return of books. Avoid fines.
                  - Library
               """.formatted(name.split(" ")[0]);
    }

    private String getSubject(){
        return "You borrow expires tomorrow";
    }

}
