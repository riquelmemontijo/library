package com.library.domain.borrow;

import com.library.domain.borrow.dto.BorrowFormDTO;
import com.library.domain.borrow.dto.BorrowInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BorrowMapper {

    BorrowInfoDTO borrowToBorrowInfoDTO(Borrow Borrow);
    Borrow borrowFormDTOtoBorrow(BorrowFormDTO BorrowFormDTO);
    
}
