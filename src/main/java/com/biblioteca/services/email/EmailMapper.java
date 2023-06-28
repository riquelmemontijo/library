package com.biblioteca.services.email;

import com.biblioteca.services.email.dto.EmailInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmailMapper {

    EmailInfoDTO emailToEmailInfoDTO(Email Email);
    
}
