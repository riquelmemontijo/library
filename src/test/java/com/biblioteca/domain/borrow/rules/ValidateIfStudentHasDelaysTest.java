package com.biblioteca.domain.borrow.rules;

import com.biblioteca.domain.borrow.Borrow;
<<<<<<< HEAD
import com.biblioteca.domain.student.Student;
import com.biblioteca.infrastructure.exception.BusinessRulesException;
import org.junit.jupiter.api.DisplayName;
=======
import com.biblioteca.domain.debit.StudentDebit;
import com.biblioteca.domain.student.Student;
import com.biblioteca.infrastructure.exception.BusinessRulesException;
>>>>>>> d14e74e (Testes de regras de negócio durante empréstimo finalizadas)
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidateIfStudentHasDelaysTest {

    @Test
<<<<<<< HEAD
    @DisplayName("Should throw exception when student has delays")
=======
>>>>>>> d14e74e (Testes de regras de negócio durante empréstimo finalizadas)
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
<<<<<<< HEAD
    @DisplayName("Shouldn't throw exception when student doesn't have delays")
    void dontThrowExceptionIfStudentDoesNotHaveDelays(){
        ValidateIfStudentHasDelays rule = new ValidateIfStudentHasDelays();

        var borrowWithoutDelay = new Borrow();
        borrowWithoutDelay.setDueDate(LocalDate.now().plusDays(1));

        var student = new Student();
        student.setBorrows(List.of(borrowWithoutDelay));
=======
    void dontThrowExceptionIfStudentDoesNotHaveDelays(){
        ValidateIfStudentHasDelays rule = new ValidateIfStudentHasDelays();

        var borrowWithDelay = new Borrow();
        borrowWithDelay.setDueDate(LocalDate.now().plusDays(1));

        var student = new Student();
        student.setBorrows(List.of(borrowWithDelay));
>>>>>>> d14e74e (Testes de regras de negócio durante empréstimo finalizadas)

        var borrowToTest = new Borrow();
        borrowToTest.setStudent(student);

        assertDoesNotThrow(() -> rule.validate(borrowToTest));
    }

}
