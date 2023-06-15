package com.biblioteca.domain.author;

import com.biblioteca.domain.author.dto.AuthorFormDTO;
import com.biblioteca.domain.author.dto.AuthorInBookDTO;
import com.biblioteca.domain.author.dto.AuthorInfoDTO;
import com.biblioteca.domain.author.dto.AuthorUpdateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorInfoDTO authorToAuthorInfoDTO(Author Author);
    Author authorFormDTOtoAuthor(AuthorFormDTO AuthorFormDTO);
    Author authorInBookDTOtoAuthor(AuthorInBookDTO authorInBookDTO);
    Author authorUpdateDTOtoAuthor(AuthorUpdateDTO authorUpdateDTO);
}
