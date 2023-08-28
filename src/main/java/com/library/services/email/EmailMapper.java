package com.library.services.email;

import com.library.services.email.dto.EmailInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmailMapper {

    EmailInfoDTO emailToEmailInfoDTO(Email Email);
    
}
