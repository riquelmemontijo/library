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

    private final Book book;
    private final ValidateIfBookHaveUnitsAvailable validator;
    private final Borrow borrow;

    public ValidateIfBookHaveUnitsAvailableTest() {
        this.book = new Book();
        this.validator = new ValidateIfBookHaveUnitsAvailable();
        this.borrow = new Borrow();
    }

    @Test
    @DisplayName("Should throw exception when book don't have available units")
    void throwExceptionIfBookDontHaveUnitsAvailable(){
        book.setAvailableUnits(0);
        borrow.setBooks(List.of(book));
        assertThrows(BusinessRulesException.class, () -> validator.validate(borrow));
    }

    @Test
    @DisplayName("Shouldn't throw exception when book have available units")
    void dontThrowExceptionIfBookHaveUnitsAvailable(){
        book.setAvailableUnits(1);
        borrow.setBooks(List.of(book));
        assertDoesNotThrow(() -> validator.validate(borrow));
    }
}
