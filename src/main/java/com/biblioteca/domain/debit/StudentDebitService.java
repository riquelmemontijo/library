package com.biblioteca.domain.debit;

import com.biblioteca.domain.borrow.Borrow;
import com.biblioteca.domain.debit.dto.StudentDebitInfoDTO;
import com.biblioteca.domain.student.StudentMapper;
import com.biblioteca.infrastructure.exception.RecordNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.UUID;

@Service
public class StudentDebitService {
    
    private final StudentDebitRepository repository;
    private final StudentDebitMapper mapper;

    public StudentDebitService(StudentDebitRepository repository, StudentDebitMapper mapper, StudentMapper studentMapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public StudentDebitInfoDTO getById(UUID id){
        return repository.findById(id)
                .map(mapper::studentToStudentDebitInfoDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Page<StudentDebitInfoDTO> getAll(Pageable pageable){
        return repository.findAll(pageable)
                .map(mapper::studentToStudentDebitInfoDTO);
    }

    public void generateStudentDebit(Borrow borrow){
        var studentDebit = new StudentDebit(calculateValueOfDebit(borrow),
                                      false,
                                            borrow,
                                            borrow.getStudent());
    }

    private BigDecimal calculateValueOfDebit(Borrow borrow) {
        long daysOfDelay = Duration.between(borrow.getBorrowDate(), borrow.getDueDate()).toDays();
        return BigDecimal.valueOf(daysOfDelay * 0.50);
    }

}
