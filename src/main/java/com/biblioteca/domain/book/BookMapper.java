package com.biblioteca.domain.book;

import com.biblioteca.domain.book.dto.BookFormDTO;
import com.biblioteca.domain.book.dto.BookInBookcaseDTO;
import com.biblioteca.domain.book.dto.BookInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookInfoDTO bookToBookInfoDTO(Book book);
    Book bookFormDTOtoBook(BookFormDTO bookFormDTO);
    Book bookInBookcaseDTOtoBook(BookInBookcaseDTO bookInBookcaseDTO);

}
