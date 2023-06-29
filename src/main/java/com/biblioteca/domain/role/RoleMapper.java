package com.biblioteca.domain.role;

import com.biblioteca.domain.role.dto.RoleInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleInfoDTO roleToRoleInfoDTO(Role Role);
    
}
