package com.biblioteca.domain.role;

import com.biblioteca.domain.role.dto.RoleInfoDTO;
import com.biblioteca.infrastructure.exception.RecordNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public RoleInfoDTO getById(UUID id){
        return roleRepository.findById(id)
                .map(roleMapper::roleToRoleInfoDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Page<RoleInfoDTO> getAll(Pageable pageable){
        return roleRepository.findAll(pageable)
                .map(roleMapper::roleToRoleInfoDTO);
    }
    
}
