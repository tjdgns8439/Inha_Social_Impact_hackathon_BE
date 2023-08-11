package com.example.success_tutor.domain.student;

import com.example.success_tutor.domain.student.dto.CreateStudentRequestDto;
import com.example.success_tutor.domain.student.dto.StudentResponseDto;
import com.example.success_tutor.global.exception.student.StudentNotFoundException;
import com.example.success_tutor.global.exception.student.StudentPhoneAlreadyExistsException;
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
        String phoneNum = dto.getPhoneNum();  // 학생 생성 요청에서 핸드폰 번호 가져옴
        if (studentRepository.existsByPhoneNum(phoneNum)) {
            throw new StudentPhoneAlreadyExistsException();  // 이미 등록된 번호인 경우 예외 발생
        }
        studentRepository.save(Student.toEntity(dto));
    }

    @Transactional
    public StudentResponseDto findStudent(Long id){
        try {
            Optional<Student> findedStudent = studentRepository.findById(id);
            return StudentResponseDto.toDto(findedStudent.get());
        }catch (RuntimeException e){
            throw new StudentNotFoundException();
        }
    }

    //delete는 리퍼지토리에 없어도 예외를 발생시키지 않기 때문에 find해서 있으면 삭제, 없으면 예외처리
    @Transactional
    public void deleteStudentById(Long Id) {
        if(!studentRepository.existsById(Id))
            throw new StudentNotFoundException();
        else{
            studentRepository.deleteById(Id);
        }
    }
}
