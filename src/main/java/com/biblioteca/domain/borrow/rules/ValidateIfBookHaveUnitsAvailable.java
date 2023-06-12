package com.biblioteca.domain.borrow.rules;

import com.biblioteca.domain.borrow.Borrow;
import com.biblioteca.infrastructure.exception.BusinessRulesException;

public class ValidateIfBookHaveUnitsAvailable implements ValidateBorrow{
    @Override
    public void validate(Borrow borrow) {
        borrow.getBooks().forEach(book -> {
            if(book.getAvailableUnits() <= 0){
                throw new BusinessRulesException("The book %s don't have available units".formatted(book.getTitle()));
            }
        });
    }
}
