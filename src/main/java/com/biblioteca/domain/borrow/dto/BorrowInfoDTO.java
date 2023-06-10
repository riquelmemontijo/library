package com.biblioteca.domain.borrow.dto;

import com.biblioteca.domain.book.dto.BookInBorrowDTO;
import com.biblioteca.domain.student.dto.StudentInBorrowDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record BorrowInfoDTO(UUID id,
                            StudentInBorrowDTO student,
                            List<BookInBorrowDTO> books,
                            LocalDateTime borrowDate,
                            LocalDateTime dueDate,
                            LocalDateTime returnDate) {
}
