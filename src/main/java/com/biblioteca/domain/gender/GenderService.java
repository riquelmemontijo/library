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
import java.util.UUID;

@Service
public class GenderService {

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private GenderMapper genderMapper;
    public GenderInfoDTO getById(UUID id){
        return genderRepository.findById(id)
                         .map(genderMapper::genderToGenderInfoDTO)
                         .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Page<GenderInfoDTO> getAll(Pageable pageable){
        return genderRepository.findAll(pageable)
                         .map(genderMapper::genderToGenderInfoDTO);
    }

    @Transactional
    public GenderInfoDTO create(GenderFormDTO data){
        var gender = genderRepository.save(genderMapper.genderFormDTOtoGender(data));
        return genderMapper.genderToGenderInfoDTO(gender);
    }

    @Transactional
    public GenderInfoDTO update(GenderUpdateDTO genderUpdateDTO){

        var gender = genderRepository.findById(genderUpdateDTO.id())
                               .orElseThrow(() -> new RecordNotFoundException(genderUpdateDTO.id()));

        gender.update(genderUpdateDTO);

        return genderMapper.genderToGenderInfoDTO(gender);
    }

    public void delete(UUID id){
        var gender = genderRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        genderRepository.delete(gender);
    }

}
