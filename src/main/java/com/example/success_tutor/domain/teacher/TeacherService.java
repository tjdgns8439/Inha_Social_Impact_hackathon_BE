package com.example.success_tutor.domain.teacher;

import com.example.success_tutor.domain.student.Student;
import com.example.success_tutor.domain.teacher.Dto.CreateTeacherRequestDto;
import com.example.success_tutor.domain.teacher.Dto.GetTeacherResponseDto;
import com.example.success_tutor.global.exception.CustomException;
import com.example.success_tutor.global.exception.student.StudentNotFoundException;
import com.example.success_tutor.global.exception.student.StudentPhoneAlreadyExistsException;
import com.example.success_tutor.global.exception.teacher.TeacherNotFoundException;
import com.example.success_tutor.global.exception.teacher.TeacherPhoneAlreadyExistsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Transactional
    public GetTeacherResponseDto findTeacherById(Long id) {
        try {
            Optional<Teacher> findedTeacher = teacherRepository.findById(id);
            return GetTeacherResponseDto.toDto(findedTeacher.get());
        }catch (RuntimeException e){
            throw new TeacherNotFoundException();
        }
    }

    /**
    * @methodName : GetTeacherResponseDto
    * @param : 
    * @return : GetTeacherResponseDto의 list
    * @Description: 전체 선생님 목록을 조회하여 GetTeacherResponseDto타입으로 바꾸고 반환합니다
    * @note:
    **/
    @Transactional
    public List<GetTeacherResponseDto> GetTeacherResponseDto() {
        List<GetTeacherResponseDto> findedTeachers = teacherRepository.findAll().stream().map(
                teacher -> GetTeacherResponseDto.toDto(teacher)
        ).toList();
        return findedTeachers;
    }

    /**
    * @methodName : createTeacher
    * @param : CreateTeacherRequestDto dto
    * @return : 
    * @Description:  CreateTeacherRequestDto를 인자로 받아 Teacher 타입으로 변환 후 저장
    * @note:
    **/
    @Transactional
    public void createTeacher(CreateTeacherRequestDto dto) {
        String phoneNum = dto.getPhoneNum();  // 학생 생성 요청에서 핸드폰 번호 가져옴
        if (teacherRepository.existsByPhoneNum(phoneNum)) {
            throw new TeacherPhoneAlreadyExistsException();  // 이미 등록된 번호인 경우 예외 발생
        }
        teacherRepository.save(Teacher.toEntity(dto));
    }


    //delete는 리퍼지토리에 없어도 예외를 발생시키지 않기 때문에 find해서 있으면 삭제, 없으면 예외처리
    @Transactional
    public void deleteTeacherById(Long Id) {
        if(!teacherRepository.existsById(Id))
            throw new TeacherNotFoundException();
        else{
            teacherRepository.deleteById(Id);
        }
    }
}
