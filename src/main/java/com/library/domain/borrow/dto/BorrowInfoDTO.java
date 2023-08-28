package com.library.domain.borrow.dto;

import com.library.domain.book.dto.BookInBorrowDTO;
import com.library.domain.student.dto.StudentInBorrowDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record BorrowInfoDTO(UUID id,
                            StudentInBorrowDTO student,
                            List<BookInBorrowDTO> books,
                            LocalDate borrowDate,
                            LocalDate dueDate,
                            LocalDate returnDate,
                            Boolean isFinished) {
}
