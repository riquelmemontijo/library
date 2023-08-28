package com.library.domain.author;

import com.library.domain.author.dto.AuthorFormDTO;
import com.library.domain.author.dto.AuthorInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorInfoDTO authorToAuthorInfoDTO(Author Author);
    Author authorFormDTOtoAuthor(AuthorFormDTO AuthorFormDTO);
}
