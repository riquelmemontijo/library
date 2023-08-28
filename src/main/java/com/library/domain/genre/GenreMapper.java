package com.library.domain.genre;

import com.library.domain.genre.dto.GenreFormDTO;
import com.library.domain.genre.dto.GenreInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreInfoDTO genderToGenderInfoDTO(Genre genre);
    Genre genderFormDTOtoGender(GenreFormDTO genreFormDTO);
}
