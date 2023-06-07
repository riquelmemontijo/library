package com.biblioteca.domain.borrow.rules;

import com.biblioteca.domain.borrow.Borrow;
import com.biblioteca.domain.borrow.BorrowRepository;
import com.biblioteca.infrastructure.exception.BusinessRulesException;
import org.springframework.stereotype.Component;

@Component
public class ValidateIfStudentHasDelays implements ValidateBorrow{
    
    private final BorrowRepository borrowRepository;

    public ValidateIfStudentHasDelays(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    @Override
    public void validate(Borrow borrow){
        var hasBorrowWithDelay = borrowRepository.findBorrowWithDelayByStudent(borrow.getStudent()).isPresent();
        if(hasBorrowWithDelay){
            throw new BusinessRulesException("Student has borrows with delay");
        }
    }
}
