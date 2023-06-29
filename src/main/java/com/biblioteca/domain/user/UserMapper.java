package com.biblioteca.domain.user;

import com.biblioteca.domain.user.User;
import com.biblioteca.domain.user.dto.UserFormDTO;
import com.biblioteca.domain.user.dto.UserInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserInfoDTO userToUserInfoDTO(User User);
    User userFormDTOtoUser(UserFormDTO UserFormDTO);
    
}
