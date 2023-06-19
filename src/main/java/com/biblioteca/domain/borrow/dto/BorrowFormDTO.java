package com.biblioteca.domain.borrow.dto;

import com.biblioteca.domain.book.dto.BookInBorrowDTO;
import com.biblioteca.domain.student.dto.StudentInBorrowDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public record BorrowFormDTO(@Valid
                            @NotNull(message = "The student is required")
                            StudentInBorrowDTO student,
                            @Valid
                            @NotNull(message = "At least one book is required")
                            List<BookInBorrowDTO> books,
                            @NotNull(message = "The borrow date is required")
                            @JsonFormat(pattern = "yyyy-MM-dd")
                            LocalDate borrowDate) {
}
