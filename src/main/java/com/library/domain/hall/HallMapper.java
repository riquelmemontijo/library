package com.library.domain.hall;

import com.library.domain.hall.dto.HallFormDTO;
import com.library.domain.hall.dto.HallInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HallMapper {

    HallInfoDTO hallToHallInfoDTO(Hall Hall);
    Hall hallFormDTOtoHall(HallFormDTO HallFormDTO);
}
