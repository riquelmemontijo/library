package com.biblioteca.domain.hall.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record HallUpdateDTO(@NotNull(message = "O id é obrigatório")
                            UUID id,
                            @NotBlank(message = "O nome do corredor é obrigatório")
                            String alias) {
}