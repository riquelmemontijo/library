package com.library.domain.borrow.rules;

import com.library.domain.borrow.Borrow;
import com.library.infrastructure.exception.BusinessRulesException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Objects;

@Component
public class ValidateIfStudentHasDelays implements ValidateBorrow{
    @Override
    public void validate(Borrow borrow){
        if(Objects.nonNull(borrow.getStudent().getBorrows())){
            borrow.getStudent().getBorrows().forEach(borrowOfStudent ->{
                if(borrowOfStudent.getDueDate().isBefore(LocalDate.now())){
                    throw new BusinessRulesException("Student has borrows with delay");
                }
            });
        }
    }
}
