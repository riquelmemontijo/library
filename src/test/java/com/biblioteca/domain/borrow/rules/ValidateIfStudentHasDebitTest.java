package com.biblioteca.domain.borrow.rules;

import com.biblioteca.domain.borrow.Borrow;
import com.biblioteca.domain.debit.StudentDebit;
import com.biblioteca.domain.student.Student;
import com.biblioteca.infrastructure.exception.BusinessRulesException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidateIfStudentHasDebitTest {

    @Test
    @DisplayName("Should throw exception when student has not paid debits")
    void throwExceptionIfStudentHasDebits(){
        ValidateIfStudentHasDebit rule = new ValidateIfStudentHasDebit();

        var studentDebit = new StudentDebit();
        studentDebit.setIsPaid(false);

        var student = new Student();
        student.setDebits(List.of(studentDebit));

        var borrow = new Borrow();
        borrow.setStudent(student);

        assertThrows(BusinessRulesException.class, () -> rule.validate(borrow));
    }

    @Test
    @DisplayName("Shouldn't throw exception when student doesn't have not paid debits")
    void dontThrowExceptionIfStudentDoesNotHaveDebits(){
        var rule = new ValidateIfStudentHasDebit();

        var studentDebit = new StudentDebit();
        studentDebit.setIsPaid(true);

        var student = new Student();
        student.setDebits(List.of(studentDebit));

        var borrow = new Borrow();
        borrow.setStudent(student);

        assertDoesNotThrow(() -> rule.validate(borrow));
    }

}
