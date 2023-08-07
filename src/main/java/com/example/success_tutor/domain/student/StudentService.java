package com.example.success_tutor.domain.student;

import com.example.success_tutor.domain.student.dto.CreateStudentRequestDto;
import com.example.success_tutor.domain.student.dto.StudentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    @Transactional
    public void createStudent(CreateStudentRequestDto dto) {
        studentRepository.save(Student.toEntity(dto));
    }

    @Transactional
    public StudentResponseDto findStudent(Long id){
        Optional<Student> findedStudent = studentRepository.findById(id);
        return StudentResponseDto.toDto(findedStudent.get());
    }
}
