package com.biblioteca.domain.borrow.rules;

import com.biblioteca.domain.book.Book;
import com.biblioteca.domain.borrow.Borrow;
import com.biblioteca.infrastructure.exception.BusinessRulesException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ValidateIfBookHaveUnitsAvailableTest {

    @Test
    void throwExceptionIfBookDontHaveUnitsAvailable(){
        ValidateIfBookHaveUnitsAvailable rule = new ValidateIfBookHaveUnitsAvailable();
        var book = new Book();
        book.setAvailableUnits(0);
        var borrow = new Borrow();
        borrow.setBooks(Arrays.asList(book));

        assertThrows(BusinessRulesException.class, () -> rule.validate(borrow));
    }

    @Test
    void dontThrowExceptionIfBookDontHaveUnitsAvailable(){
        ValidateIfBookHaveUnitsAvailable rule = new ValidateIfBookHaveUnitsAvailable();
        var book = new Book();
        book.setAvailableUnits(1);
        var borrow = new Borrow();
        borrow.setBooks(Arrays.asList(book));
    }
}
