package com.library.domain.debit.dto;

import com.library.domain.borrow.dto.BorrowInStudentDebitDTO;
import com.library.domain.student.dto.StudentInStudentDebit;

import java.math.BigDecimal;
import java.util.UUID;

public record StudentDebitInfoDTO(UUID id, BigDecimal value, Boolean isPaid, BorrowInStudentDebitDTO borrow, StudentInStudentDebit student) {
}
