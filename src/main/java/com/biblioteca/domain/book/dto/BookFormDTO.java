package com.biblioteca.domain.book.dto;

import com.biblioteca.domain.author.dto.AuthorInBookDTO;
import com.biblioteca.domain.bookcase.dto.BookcaseInBookDTO;
import com.biblioteca.domain.gender.dto.GenderInBookDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

public record BookFormDTO(@NotBlank(message = "O titulo é obrigatório")
                          String title,
                          @Valid
                          @NotNull(message = "Ao menos um gênero é obrigatório")
                          List<GenderInBookDTO> genders,
                          @Valid
                          List<BookcaseInBookDTO> bookcases,
                          @Valid
                          @NotNull(message = "O autor é obrigatório")
                          List<AuthorInBookDTO> authors,
                          @PositiveOrZero(message = "A quantidade de unidades deve ser iguail ou maior que zero")
                          Integer units,
                          @PositiveOrZero(message = "As unidades disponíveis deve ser iguail ou maior que zero")
                          Integer availableUnits) {
}
