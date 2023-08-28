package com.library.domain.bookcase;

import com.library.domain.bookcase.dto.BookcaseFormDTO;
import com.library.domain.bookcase.dto.BookcaseInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookcaseMapper {

    BookcaseInfoDTO bookcaseToBookcaseInfoDTO(Bookcase bookcase);
    Bookcase bookcaseFormDTOtoBookcase(BookcaseFormDTO bookcaseFormDTO);

}
