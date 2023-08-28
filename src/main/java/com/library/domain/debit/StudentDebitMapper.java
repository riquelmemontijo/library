package com.library.domain.debit;

import com.library.domain.debit.dto.StudentDebitInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentDebitMapper {
    StudentDebitInfoDTO studentToStudentDebitInfoDTO(StudentDebit studentDebit);
}
