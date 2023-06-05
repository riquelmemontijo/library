package com.biblioteca.domain.borrow;

import com.biblioteca.domain.borrow.dto.BorrowFormDTO;
import com.biblioteca.domain.borrow.dto.BorrowInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BorrowMapper {

    BorrowInfoDTO borrowToBorrowInfoDTO(Borrow Borrow);
    Borrow borrowFormDTOtoBorrow(BorrowFormDTO BorrowFormDTO);
    
}
