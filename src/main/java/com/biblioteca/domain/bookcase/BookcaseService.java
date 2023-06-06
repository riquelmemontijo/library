package com.biblioteca.domain.bookcase;

import com.biblioteca.domain.bookcase.dto.BookcaseFormDTO;
import com.biblioteca.domain.bookcase.dto.BookcaseInfoDTO;
import com.biblioteca.domain.bookcase.dto.BookcaseUpdateDTO;
import com.biblioteca.infrastructure.exception.RecordNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class BookcaseService {

    private final BookcaseRepository bookcaseRepository;
    private final BookcaseMapper bookcaseMapper;

    public BookcaseService(BookcaseRepository bookcaseRepository, BookcaseMapper bookcaseMapper) {
        this.bookcaseRepository = bookcaseRepository;
        this.bookcaseMapper = bookcaseMapper;
    }

    public BookcaseInfoDTO getById(UUID id){
        return bookcaseRepository.findById(id)
                .map(bookcaseMapper::bookcaseToBookcaseInfoDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Page<BookcaseInfoDTO> getAll(Pageable pageable){
        return bookcaseRepository.findAll(pageable)
                .map(bookcaseMapper::bookcaseToBookcaseInfoDTO);
    }

    @Transactional
    public BookcaseInfoDTO create(BookcaseFormDTO data){
        var bookcase = bookcaseRepository.save(bookcaseMapper.bookcaseFormDTOtoBookcase(data));
        return bookcaseMapper.bookcaseToBookcaseInfoDTO(bookcase);
    }

    @Transactional
    public BookcaseInfoDTO update(BookcaseUpdateDTO bookcaseUpdateDTO){

        var bookcase = bookcaseRepository.findById(bookcaseUpdateDTO.id())
                .orElseThrow(() -> new RecordNotFoundException(bookcaseUpdateDTO.id()));

        bookcase.update(bookcaseUpdateDTO);

        return bookcaseMapper.bookcaseToBookcaseInfoDTO(bookcase);
    }

    public void delete(UUID id){
        var bookcase = bookcaseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        bookcaseRepository.delete(bookcase);
    }
}
