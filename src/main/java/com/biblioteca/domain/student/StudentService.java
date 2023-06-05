package com.biblioteca.domain.student;

import com.biblioteca.domain.student.dto.StudentFormDTO;
import com.biblioteca.domain.student.dto.StudentInfoDTO;
import com.biblioteca.domain.student.dto.StudentUpdateDTO;
import com.biblioteca.infrastructure.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;
    public StudentInfoDTO getById(UUID id){
        return studentRepository.findById(id)
                .map(studentMapper::studentToStudentInfoDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Page<StudentInfoDTO> getAll(Pageable pageable){
        return studentRepository.findAll(pageable)
                .map(studentMapper::studentToStudentInfoDTO);
    }

    @Transactional
    public StudentInfoDTO create(StudentFormDTO data){
        var student = studentRepository.save(studentMapper.studentFormDTOtoStudent(data));
        return studentMapper.studentToStudentInfoDTO(student);
    }

    @Transactional
    public StudentInfoDTO update(StudentUpdateDTO studentUpdateDTO){

        var student = studentRepository.findById(studentUpdateDTO.id())
                .orElseThrow(() -> new RecordNotFoundException(studentUpdateDTO.id()));

        student.update(studentUpdateDTO);

        return studentMapper.studentToStudentInfoDTO(student);
    }

    public void delete(UUID id){
        var student = studentRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        studentRepository.delete(student);
    }
    
}
