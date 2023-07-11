package com.biblioteca.domain.user;

import com.biblioteca.domain.user.dto.UserFormDTO;
import com.biblioteca.domain.user.dto.UserInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserInfoDTO userToUserInfoDTO(UserDomain UserDomain);
    UserDomain userFormDTOtoUser(UserFormDTO UserFormDTO);
    
}
