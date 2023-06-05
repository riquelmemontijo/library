package com.biblioteca.domain.student;

import com.biblioteca.domain.student.dto.StudentFormDTO;
import com.biblioteca.domain.student.dto.StudentInBorrowDTO;
import com.biblioteca.domain.student.dto.StudentInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentInfoDTO studentToStudentInfoDTO(Student Student);
    Student studentFormDTOtoStudent(StudentFormDTO StudentFormDTO);
    Student studentInBorrowDTOtoStudent(StudentInBorrowDTO studentInBorrowDTO);
    
}
