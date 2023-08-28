package com.library.domain.role;

import com.library.domain.role.dto.RoleInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleInfoDTO roleToRoleInfoDTO(Role Role);
    
}
