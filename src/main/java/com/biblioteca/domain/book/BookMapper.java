package com.biblioteca.domain.book;

import com.biblioteca.domain.book.dto.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookInfoDTO bookToBookInfoDTO(Book book);
    Book bookFormDTOtoBook(BookFormDTO bookFormDTO);
}
