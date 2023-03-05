package com.biblioteca.domain.gender;

import com.biblioteca.domain.gender.dto.GenderFormDTO;
import com.biblioteca.domain.gender.dto.GenderInfoDTO;
import com.biblioteca.domain.gender.dto.GenderUpdateDTO;
import com.biblioteca.infrastructure.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class GenderService {

    @Autowired
    private GenderRepository repository;

    @Autowired
    private GenderMapper genderMapper;
    public GenderInfoDTO getById(UUID id){
        return repository.findById(id)
                         .map(genderMapper::genderToGenderInfoDTO)
                         .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Page<GenderInfoDTO> getAll(Pageable pageable){
        return repository.findAll(pageable)
                         .map(genderMapper::genderToGenderInfoDTO);
    }

    @Transactional
    public GenderInfoDTO create(GenderFormDTO data){
        var gender = repository.save(genderMapper.genderFormDTOtoGender(data));
        return genderMapper.genderToGenderInfoDTO(gender);
    }

    @Transactional
    public GenderInfoDTO update(GenderUpdateDTO genderUpdateDTO){

        var gender = repository.findById(genderUpdateDTO.id())
                               .orElseThrow(() -> new RecordNotFoundException(genderUpdateDTO.id()));

        gender.update(genderUpdateDTO);

        return genderMapper.genderToGenderInfoDTO(gender);
    }

    public void delete(UUID id){
        var gender = repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        repository.delete(gender);
    }

}
