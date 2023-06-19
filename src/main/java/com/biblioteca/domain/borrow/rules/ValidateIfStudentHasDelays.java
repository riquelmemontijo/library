package com.biblioteca.domain.borrow.rules;

import com.biblioteca.domain.borrow.Borrow;
import com.biblioteca.infrastructure.exception.BusinessRulesException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ValidateIfStudentHasDelays implements ValidateBorrow{
    @Override
    public void validate(Borrow borrow){
        borrow.getStudent().getBorrows().forEach(borrowOfStudent ->{
            if(borrowOfStudent.getDueDate().isBefore(LocalDate.now())){
                throw new BusinessRulesException("Student has borrows with delay");
            }
        });
    }
}
