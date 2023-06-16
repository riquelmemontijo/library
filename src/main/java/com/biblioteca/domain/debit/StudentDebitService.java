package com.biblioteca.domain.debit;

import com.biblioteca.domain.borrow.Borrow;
import com.biblioteca.domain.debit.dto.StudentDebitInfoDTO;
import com.biblioteca.domain.debit.dto.StudentDebitPaidDTO;
import com.biblioteca.infrastructure.exception.RecordNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.UUID;

@Service
public class StudentDebitService {

    private final StudentDebitRepository studentDebitRepository;
    private final StudentDebitMapper studentDebitMapper;

    public StudentDebitService(StudentDebitRepository studentDebitRepository, StudentDebitMapper studentDebitMapper) {
        this.studentDebitRepository = studentDebitRepository;
        this.studentDebitMapper = studentDebitMapper;
    }

    public StudentDebitInfoDTO getById(UUID id){
        return studentDebitRepository.findById(id)
                .map(studentDebitMapper::studentToStudentDebitInfoDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Page<StudentDebitInfoDTO> getAll(Pageable pageable){
        return studentDebitRepository.findAll(pageable)
                .map(studentDebitMapper::studentToStudentDebitInfoDTO);
    }

    public void generateStudentDebit(Borrow borrow){
        var studentDebit = new StudentDebit(calculateValueOfDebit(borrow),
                                      false,
                                            borrow,
                                            borrow.getStudent());
        studentDebitRepository.save(studentDebit);
    }

    private BigDecimal calculateValueOfDebit(Borrow borrow) {
        long daysOfDelay = Duration.between(borrow.getDueDate(), borrow.getReturnDate()).toDays();
        return BigDecimal.valueOf((daysOfDelay * 0.50) + 2.50);
    }

    public StudentDebitInfoDTO paidDebit(StudentDebitPaidDTO data){
        var studentDebit = studentDebitRepository.findById(data.id())
                 .orElseThrow(() -> new RecordNotFoundException(data.id()));
        studentDebit.setPaid(true);
        return studentDebitMapper.studentToStudentDebitInfoDTO(studentDebit);
    }

}
