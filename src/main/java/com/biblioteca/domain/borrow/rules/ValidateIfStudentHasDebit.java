package com.biblioteca.domain.borrow.rules;

import com.biblioteca.domain.borrow.Borrow;
import com.biblioteca.domain.borrow.BorrowRepository;
import com.biblioteca.infrastructure.exception.BusinessRulesException;
import org.springframework.stereotype.Component;

@Component
public class ValidateIfStudentHasDebit implements ValidateBorrow{
    private final BorrowRepository borrowRepository;

    public ValidateIfStudentHasDebit(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    @Override
    public void validate(Borrow borrow){
        var hasNotPaidDebits = borrowRepository.findBorrowWithDelayByStudent(borrow.getStudent().getId()).isPresent();
        if(hasNotPaidDebits){
            throw new BusinessRulesException("Student has not paid debits");
        }
    }
}
