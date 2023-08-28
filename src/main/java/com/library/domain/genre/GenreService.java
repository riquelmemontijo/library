package com.library.domain.genre;

import com.library.domain.genre.dto.GenreFormDTO;
import com.library.domain.genre.dto.GenreInfoDTO;
import com.library.domain.genre.dto.GenreUpdateDTO;
import com.library.infrastructure.exception.RecordNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.UUID;

@Service
public class GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public GenreService(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    public GenreInfoDTO getById(UUID id){
        return genreRepository.findById(id)
                         .map(genreMapper::genderToGenderInfoDTO)
                         .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Page<GenreInfoDTO> getAll(Pageable pageable){
        return genreRepository.findAll(pageable)
                         .map(genreMapper::genderToGenderInfoDTO);
    }

    @Transactional
    public GenreInfoDTO create(GenreFormDTO data){
        var gender = genreRepository.save(genreMapper.genderFormDTOtoGender(data));
        return genreMapper.genderToGenderInfoDTO(gender);
    }

    @Transactional
    public GenreInfoDTO update(GenreUpdateDTO genreUpdateDTO){

        var gender = genreRepository.findById(genreUpdateDTO.id())
                               .orElseThrow(() -> new RecordNotFoundException(genreUpdateDTO.id()));

        gender.update(genreUpdateDTO);

        return genreMapper.genderToGenderInfoDTO(gender);
    }

    public void delete(UUID id){
        var gender = genreRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        genreRepository.delete(gender);
    }

}
