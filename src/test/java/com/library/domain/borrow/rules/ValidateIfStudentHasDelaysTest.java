package com.library.domain.borrow.rules;

import com.library.domain.borrow.Borrow;
import com.library.domain.student.Student;
import com.library.infrastructure.exception.BusinessRulesException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidateIfStudentHasDelaysTest {

    private final ValidateIfStudentHasDelays validator;
    private final Borrow borrowWithDelay;
    private final Borrow borrowWithoutDelay;
    private final Borrow borrowToTest;
    private final Student student;

    public ValidateIfStudentHasDelaysTest() {
        validator = new ValidateIfStudentHasDelays();
        borrowWithDelay = new Borrow();
        borrowWithoutDelay = new Borrow();
        borrowToTest = new Borrow();
        student = new Student();
    }

    @Test
    @DisplayName("Should throw exception when student has delays")
    void throwExceptionIfStudentHasDelays(){
        borrowWithDelay.setDueDate(LocalDate.now().minusDays(1));
        student.setBorrows(List.of(borrowWithDelay));
        borrowToTest.setStudent(student);

        assertThrows(BusinessRulesException.class, () -> validator.validate(borrowToTest));
    }

    @Test
    @DisplayName("Shouldn't throw exception when student doesn't have delays")
    void dontThrowExceptionIfStudentDoesNotHaveDelays(){
        borrowWithoutDelay.setDueDate(LocalDate.now().plusDays(1));
        student.setBorrows(List.of(borrowWithoutDelay));
        borrowToTest.setStudent(student);

        assertDoesNotThrow(() -> validator.validate(borrowToTest));
    }

}
