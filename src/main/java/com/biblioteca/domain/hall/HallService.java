package com.biblioteca.domain.hall;

import com.biblioteca.domain.hall.dto.HallFormDTO;
import com.biblioteca.domain.hall.dto.HallInfoDTO;
import com.biblioteca.domain.hall.dto.HallUpdateDTO;
import com.biblioteca.infrastructure.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class HallService {

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private HallMapper hallMapper;
    public HallInfoDTO getById(UUID id){
        return hallRepository.findById(id)
                .map(hallMapper::hallToHallInfoDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Page<HallInfoDTO> getAll(Pageable pageable){
        return hallRepository.findAll(pageable)
                .map(hallMapper::hallToHallInfoDTO);
    }

    @Transactional
    public HallInfoDTO create(HallFormDTO data){
        var hall = hallRepository.save(hallMapper.hallFormDTOtoHall(data));
        return hallMapper.hallToHallInfoDTO(hall);
    }

    @Transactional
    public HallInfoDTO update(HallUpdateDTO hallUpdateDTO){

        var hall = hallRepository.findById(hallUpdateDTO.id())
                .orElseThrow(() -> new RecordNotFoundException(hallUpdateDTO.id()));

        hall.update(hallUpdateDTO);

        return hallMapper.hallToHallInfoDTO(hall);
    }

    public void delete(UUID id){
        var hall = hallRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        hallRepository.delete(hall);
    }
    
}
