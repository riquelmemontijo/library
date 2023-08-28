package com.library.domain.borrow.rules;

import com.library.domain.book.Book;
import com.library.domain.borrow.Borrow;
import com.library.infrastructure.exception.BusinessRulesException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidateIfBookHaveUnitsAvailableTest {

    @Test
    @DisplayName("Should throw exception when book don't have available units")
    void throwExceptionIfBookDontHaveUnitsAvailable(){
        ValidateIfBookHaveUnitsAvailable rule = new ValidateIfBookHaveUnitsAvailable();
        var book = new Book();
        book.setAvailableUnits(0);
        var borrow = new Borrow();
        borrow.setBooks(List.of(book));

        assertThrows(BusinessRulesException.class, () -> rule.validate(borrow));
    }

    @Test
    @DisplayName("Shouldn't throw exception when book have available units")
    void dontThrowExceptionIfBookHaveUnitsAvailable(){
        ValidateIfBookHaveUnitsAvailable rule = new ValidateIfBookHaveUnitsAvailable();
        var book = new Book();
        book.setAvailableUnits(1);
        var borrow = new Borrow();
        borrow.setBooks(List.of(book));

        assertDoesNotThrow(() -> rule.validate(borrow));
    }
}
