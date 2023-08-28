package com.library.domain.borrow.rules;

import com.library.domain.borrow.Borrow;
import com.library.infrastructure.exception.BusinessRulesException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ValidateIfStudentHasDebit implements ValidateBorrow{
    @Override
    public void validate(Borrow borrow){
        if(Objects.nonNull(borrow.getStudent().getDebits())){
            borrow.getStudent().getDebits().forEach(studentDebit -> {
                if (!studentDebit.getPaid()){
                    throw new BusinessRulesException("Student has not paid debits");
                }
            });
        }
    }
}
