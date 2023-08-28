package com.library.domain.user;

import com.library.domain.user.dto.UserFormDTO;
import com.library.domain.user.dto.UserInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserInfoDTO userToUserInfoDTO(UserDomain UserDomain);
    UserDomain userFormDTOtoUser(UserFormDTO UserFormDTO);
    
}
