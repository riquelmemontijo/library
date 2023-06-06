package com.biblioteca.domain.borrow.dto;

import com.biblioteca.domain.book.dto.BookInBorrowDTO;
import com.biblioteca.domain.student.dto.StudentInBorrowDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record BorrowUpdateDTO(@NotNull(message = "O id é obrigatório")
                              UUID id,
                              @Valid
                              @NotNull(message = "O estudande é obrigatório")
                              StudentInBorrowDTO student,
                              @Valid
                              @NotNull(message = "Ao menos um livro é obrigatório")
                              List<BookInBorrowDTO> books,
                              @NotNull(message = "A data do empréstimo é obrigatória")
                              @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                              LocalDateTime borrowDate) {
}
