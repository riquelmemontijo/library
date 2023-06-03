package com.biblioteca.domain.bookcase;

import com.biblioteca.domain.bookcase.dto.BookcaseFormDTO;
import com.biblioteca.domain.bookcase.dto.BookcaseInBookDTO;
import com.biblioteca.domain.bookcase.dto.BookcaseInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookcaseMapper {

    BookcaseInfoDTO bookcaseToBookcaseInfoDTO(Bookcase bookcase);
    Bookcase bookcaseFormDTOtoBookcase(BookcaseFormDTO bookcaseFormDTO);
    Bookcase bookcaseInBookDTOtoBookcase(BookcaseInBookDTO bookcaseInBookDTO);

}
