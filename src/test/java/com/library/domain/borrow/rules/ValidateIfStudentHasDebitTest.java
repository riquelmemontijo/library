package com.library.domain.borrow.rules;

import com.library.domain.borrow.Borrow;
import com.library.domain.debit.StudentDebit;
import com.library.domain.student.Student;
import com.library.infrastructure.exception.BusinessRulesException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidateIfStudentHasDebitTest {

    private final ValidateIfStudentHasDebit validator;
    private final Student student;
    private final StudentDebit studentDebit;
    private final Borrow borrow;

    public ValidateIfStudentHasDebitTest() {
        validator = new ValidateIfStudentHasDebit();
        student = new Student();
        studentDebit = new StudentDebit();
        borrow = new Borrow();
    }

    @Test
    @DisplayName("Should throw exception when student has not paid debits")
    void throwExceptionIfStudentHasDebits(){
        studentDebit.setPaid(false);
        student.setDebits(List.of(studentDebit));
        borrow.setStudent(student);

        assertThrows(BusinessRulesException.class, () -> validator.validate(borrow));
    }

    @Test
    @DisplayName("Shouldn't throw exception when student doesn't have not paid debits")
    void dontThrowExceptionIfStudentDoesNotHaveDebits(){
        studentDebit.setPaid(true);
        student.setDebits(List.of(studentDebit));
        borrow.setStudent(student);

        assertDoesNotThrow(() -> validator.validate(borrow));
    }

}
