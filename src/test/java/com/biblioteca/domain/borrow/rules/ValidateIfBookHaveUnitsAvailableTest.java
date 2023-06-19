package com.biblioteca.domain.borrow.rules;

import com.biblioteca.domain.book.Book;
import com.biblioteca.domain.borrow.Borrow;
import com.biblioteca.infrastructure.exception.BusinessRulesException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidateIfBookHaveUnitsAvailableTest {

    @Test
    void throwExceptionIfBookDontHaveUnitsAvailable(){
        ValidateIfBookHaveUnitsAvailable rule = new ValidateIfBookHaveUnitsAvailable();
        var book = new Book();
        book.setAvailableUnits(0);
        var borrow = new Borrow();
        borrow.setBooks(List.of(book));

        assertThrows(BusinessRulesException.class, () -> rule.validate(borrow));
    }

    @Test
    void dontThrowExceptionIfBookHaveUnitsAvailable(){
        ValidateIfBookHaveUnitsAvailable rule = new ValidateIfBookHaveUnitsAvailable();
        var book = new Book();
        book.setAvailableUnits(1);
        var borrow = new Borrow();
        borrow.setBooks(List.of(book));

        assertDoesNotThrow(() -> rule.validate(borrow));
    }
}
