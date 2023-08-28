package com.library.domain.student;

import com.library.domain.student.dto.StudentFormDTO;
import com.library.domain.student.dto.StudentInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentInfoDTO studentToStudentInfoDTO(Student Student);
    Student studentFormDTOtoStudent(StudentFormDTO StudentFormDTO);

}
