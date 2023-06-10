package com.biblioteca.domain.borrow.rules;

import com.biblioteca.domain.book.Book;
import com.biblioteca.domain.borrow.Borrow;
import com.biblioteca.infrastructure.exception.BusinessRulesException;

import java.util.List;

public class ValidateIfBookIsAvailable implements ValidateBorrow{
    @Override
    public void validate(Borrow borrow) {
        List<Book> books = borrow.getBooks();
        books.forEach(book -> {
            if(book.getAvailableUnits() <= 0){
                throw new BusinessRulesException("The book %s isn't available".formatted(book.getTitle()));
            }
        });
    }
}
