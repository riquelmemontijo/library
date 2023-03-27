package com.biblioteca.domain.gender;

import com.biblioteca.domain.gender.dto.GenderFormDTO;
import com.biblioteca.domain.gender.dto.GenderInBookDTO;
import com.biblioteca.domain.gender.dto.GenderInfoDTO;
import com.biblioteca.domain.gender.dto.GenderUpdateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenderMapper {
    GenderInfoDTO genderToGenderInfoDTO(Gender gender);
    Gender genderFormDTOtoGender(GenderFormDTO genderFormDTO);
    Gender genderInBookDTOtoGender(GenderInBookDTO genderInBookDTO);
}