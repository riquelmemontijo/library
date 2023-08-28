package com.library.domain.author;

import com.library.domain.author.dto.AuthorFormDTO;
import com.library.domain.author.dto.AuthorInfoDTO;
import com.library.domain.author.dto.AuthorUpdateDTO;
import com.library.infrastructure.exception.RecordNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.UUID;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public AuthorInfoDTO getById(UUID id){
        return authorRepository.findById(id)
                .map(authorMapper::authorToAuthorInfoDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Page<AuthorInfoDTO> getAll(Pageable pageable){
        return authorRepository.findAll(pageable)
                .map(authorMapper::authorToAuthorInfoDTO);
    }

    @Transactional
    public AuthorInfoDTO create(AuthorFormDTO data){
        var author = authorRepository.save(authorMapper.authorFormDTOtoAuthor(data));
        return authorMapper.authorToAuthorInfoDTO(author);
    }

    @Transactional
    public AuthorInfoDTO update(AuthorUpdateDTO authorUpdateDTO){

        var author = authorRepository.findById(authorUpdateDTO.id())
                .orElseThrow(() -> new RecordNotFoundException(authorUpdateDTO.id()));

        author.update(authorUpdateDTO);

        return authorMapper.authorToAuthorInfoDTO(author);
    }

    public void delete(UUID id){
        var author = authorRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        authorRepository.delete(author);
    }
    
}
