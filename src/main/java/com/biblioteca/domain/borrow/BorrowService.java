package com.biblioteca.domain.borrow;

import com.biblioteca.domain.borrow.BorrowMapper;
import com.biblioteca.domain.borrow.BorrowRepository;
import com.biblioteca.domain.borrow.dto.BorrowFormDTO;
import com.biblioteca.domain.borrow.dto.BorrowInfoDTO;
import com.biblioteca.domain.borrow.dto.BorrowUpdateDTO;
import com.biblioteca.infrastructure.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BorrowMapper borrowMapper;
    public BorrowInfoDTO getById(UUID id){
        return borrowRepository.findById(id)
                .map(borrowMapper::borrowToBorrowInfoDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Page<BorrowInfoDTO> getAll(Pageable pageable){
        return borrowRepository.findAll(pageable)
                .map(borrowMapper::borrowToBorrowInfoDTO);
    }

    @Transactional
    public BorrowInfoDTO create(BorrowFormDTO data){
        var borrow = borrowRepository.save(borrowMapper.borrowFormDTOtoBorrow(data));
        return borrowMapper.borrowToBorrowInfoDTO(borrow);
    }

    @Transactional
    public BorrowInfoDTO update(BorrowUpdateDTO borrowUpdateDTO){

        var borrow = borrowRepository.findById(borrowUpdateDTO.id())
                .orElseThrow(() -> new RecordNotFoundException(borrowUpdateDTO.id()));

        borrow.update(borrowUpdateDTO);

        return borrowMapper.borrowToBorrowInfoDTO(borrow);
    }

    public void delete(UUID id){
        var borrow = borrowRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        borrowRepository.delete(borrow);
    }
    
}
