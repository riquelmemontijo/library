package com.library.domain.hall;

import com.library.domain.hall.dto.HallFormDTO;
import com.library.domain.hall.dto.HallInfoDTO;
import com.library.domain.hall.dto.HallUpdateDTO;
import com.library.infrastructure.exception.RecordNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.UUID;

@Service
public class HallService {

    private final HallRepository hallRepository;
    private final HallMapper hallMapper;

    public HallService(HallRepository hallRepository, HallMapper hallMapper) {
        this.hallRepository = hallRepository;
        this.hallMapper = hallMapper;
    }

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
