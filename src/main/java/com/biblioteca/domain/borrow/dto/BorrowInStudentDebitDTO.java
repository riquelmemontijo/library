package com.biblioteca.domain.borrow.dto;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public record BorrowInStudentDebitDTO(@NotNull(message = "The borrow id is required") UUID id) {
}
