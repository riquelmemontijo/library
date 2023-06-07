package com.biblioteca.domain.debit.dto;

import com.biblioteca.domain.borrow.dto.BorrowInStudentDebitDTO;
import com.biblioteca.domain.student.dto.StudentInStudentDebit;

import java.math.BigDecimal;
import java.util.UUID;

public record StudentDebitInfoDTO(UUID id, BigDecimal value, Boolean isPaid, BorrowInStudentDebitDTO borrow, StudentInStudentDebit student) {
}
