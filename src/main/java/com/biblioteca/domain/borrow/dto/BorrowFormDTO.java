package com.biblioteca.domain.borrow.dto;

import com.biblioteca.domain.book.dto.BookInBorrowDTO;
import com.biblioteca.domain.student.dto.StudentInBorrowDTO;

import java.time.LocalDateTime;
import java.util.List;

public record BorrowFormDTO(StudentInBorrowDTO student,
                            List<BookInBorrowDTO> books,
                            LocalDateTime borrowDate) {
}
