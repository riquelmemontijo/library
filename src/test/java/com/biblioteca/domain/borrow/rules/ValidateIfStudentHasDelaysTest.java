package com.biblioteca.domain.borrow.rules;

import com.biblioteca.domain.borrow.Borrow;
import com.biblioteca.domain.debit.StudentDebit;
import com.biblioteca.domain.student.Student;
import com.biblioteca.infrastructure.exception.BusinessRulesException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidateIfStudentHasDelaysTest {

    @Test
    void throwExceptionIfStudentHasDelays(){
        ValidateIfStudentHasDelays rule = new ValidateIfStudentHasDelays();

        var borrowWithDelay = new Borrow();
        borrowWithDelay.setDueDate(LocalDate.now().minusDays(1));

        var student = new Student();
        student.setBorrows(List.of(borrowWithDelay));

        var borrowToTest = new Borrow();
        borrowToTest.setStudent(student);

        assertThrows(BusinessRulesException.class, () -> rule.validate(borrowToTest));
    }

    @Test
    void dontThrowExceptionIfStudentDoesNotHaveDelays(){
        ValidateIfStudentHasDelays rule = new ValidateIfStudentHasDelays();

        var borrowWithDelay = new Borrow();
        borrowWithDelay.setDueDate(LocalDate.now().plusDays(1));

        var student = new Student();
        student.setBorrows(List.of(borrowWithDelay));

        var borrowToTest = new Borrow();
        borrowToTest.setStudent(student);

        assertDoesNotThrow(() -> rule.validate(borrowToTest));
    }

}
