package com.biblioteca.domain.borrow.rules;

import com.biblioteca.domain.borrow.Borrow;
import com.biblioteca.domain.borrow.BorrowRepository;
import com.biblioteca.domain.debit.StudentDebitRepository;
import com.biblioteca.infrastructure.exception.BusinessRulesException;
import org.springframework.stereotype.Component;

@Component
public class ValidateIfStudentHasDebit implements ValidateBorrow{
    private final StudentDebitRepository studentDebitRepository;

    public ValidateIfStudentHasDebit(StudentDebitRepository studentDebitRepository) {
        this.studentDebitRepository = studentDebitRepository;
    }

    @Override
    public void validate(Borrow borrow){
        var hasNotPaidDebits = studentDebitRepository.findNotPaidDebitsByStudent(borrow.getStudent()).isPresent();
        if(hasNotPaidDebits){
            throw new BusinessRulesException("Student has not paid debits");
        }
    }
}
