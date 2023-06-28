package com.biblioteca.domain.debit.dto;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record StudentDebitPaidDTO (@NotNull(message = "The id is required") UUID id){
}
