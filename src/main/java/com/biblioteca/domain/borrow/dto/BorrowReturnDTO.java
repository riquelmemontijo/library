package com.biblioteca.domain.borrow.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record BorrowReturnDTO (UUID id, LocalDateTime dueDate){
}
