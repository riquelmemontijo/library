package com.biblioteca.domain.borrow.rules;

import com.biblioteca.domain.borrow.Borrow;
import com.biblioteca.domain.debit.StudentDebit;
import com.biblioteca.domain.student.Student;
import com.biblioteca.infrastructure.exception.BusinessRulesException;
<<<<<<< HEAD
import org.junit.jupiter.api.DisplayName;
=======
>>>>>>> d14e74e (Testes de regras de negócio durante empréstimo finalizadas)
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidateIfStudentHasDebitTest {

    @Test
<<<<<<< HEAD
    @DisplayName("Should throw exception when student has not paid debits")
=======
>>>>>>> d14e74e (Testes de regras de negócio durante empréstimo finalizadas)
    void throwExceptionIfStudentHasDebits(){
        ValidateIfStudentHasDebit rule = new ValidateIfStudentHasDebit();

        var studentDebit = new StudentDebit();
        studentDebit.setPaid(false);

        var student = new Student();
        student.setDebits(List.of(studentDebit));

        var borrow = new Borrow();
        borrow.setStudent(student);

        assertThrows(BusinessRulesException.class, () -> rule.validate(borrow));
    }

    @Test
<<<<<<< HEAD
    @DisplayName("Shouldn't throw exception when student doesn't have not paid debits")
=======
>>>>>>> d14e74e (Testes de regras de negócio durante empréstimo finalizadas)
    void dontThrowExceptionIfStudentDoesNotHaveDebits(){
        var rule = new ValidateIfStudentHasDebit();

        var studentDebit = new StudentDebit();
        studentDebit.setPaid(true);

        var student = new Student();
        student.setDebits(List.of(studentDebit));

        var borrow = new Borrow();
        borrow.setStudent(student);

        assertDoesNotThrow(() -> rule.validate(borrow));
    }

}
