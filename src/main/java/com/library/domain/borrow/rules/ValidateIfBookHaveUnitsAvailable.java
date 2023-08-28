package com.library.domain.borrow.rules;

import com.library.domain.borrow.Borrow;
import com.library.infrastructure.exception.BusinessRulesException;
import org.springframework.stereotype.Component;

@Component
public class ValidateIfBookHaveUnitsAvailable implements ValidateBorrow{
    @Override
    public void validate(Borrow borrow) {
        borrow.getBooks().forEach(book -> {
            if(book.getAvailableUnits() <= 0){
                throw new BusinessRulesException("The book %s don't have available units".formatted(book.getTitle()));
            }
            else{
                System.out.println("Sou trouxa");
            }
        });
    }
}