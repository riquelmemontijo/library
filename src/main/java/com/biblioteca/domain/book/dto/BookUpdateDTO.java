package com.biblioteca.domain.book.dto;

import com.biblioteca.domain.author.dto.AuthorInBookDTO;
import com.biblioteca.domain.bookcase.dto.BookcaseInBookDTO;
import com.biblioteca.domain.gender.dto.GenderInBookDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public record BookUpdateDTO(@NotNull(message = "O id é obrigatorio")
                            UUID id,
                            @NotBlank(message = "O título é obrigatório")
                            String title,
                            @Valid
                            @NotNull(message = "Ao menos um gênero é obrigatório")
                            List<GenderInBookDTO> genders,
                            @Valid
                            List<BookcaseInBookDTO> bookcases,
                            @Valid
                            @NotNull(message = "O autor é obrigatório")
                            List<AuthorInBookDTO> authors) {
}
