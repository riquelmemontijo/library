package com.biblioteca.domain.debit;

import com.biblioteca.domain.debit.dto.StudentDebitInfoDTO;
import com.biblioteca.domain.student.dto.StudentInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentDebitMapper {
    StudentDebitInfoDTO studentToStudentDebitInfoDTO(StudentDebit studentDebit);
}
