package com.biblioteca.domain.genre;

import com.biblioteca.domain.genre.dto.GenreFormDTO;
import com.biblioteca.domain.genre.dto.GenreInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreInfoDTO genderToGenderInfoDTO(Genre genre);
    Genre genderFormDTOtoGender(GenreFormDTO genreFormDTO);
}
