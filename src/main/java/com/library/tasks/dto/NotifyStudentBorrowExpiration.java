package com.library.tasks.dto;

import java.time.LocalDate;

public record NotifyStudentBorrowExpiration(String name, String email, LocalDate dueDate) {
}
