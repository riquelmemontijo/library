package com.biblioteca.domain.hall;

import com.biblioteca.domain.hall.dto.HallFormDTO;
import com.biblioteca.domain.hall.dto.HallInBookcaseDTO;
import com.biblioteca.domain.hall.dto.HallInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HallMapper {

    HallInfoDTO hallToHallInfoDTO(Hall Hall);
    Hall hallFormDTOtoHall(HallFormDTO HallFormDTO);
}
