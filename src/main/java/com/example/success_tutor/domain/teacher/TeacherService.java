package com.example.success_tutor.domain.teacher;

import com.example.success_tutor.domain.teacher.Dto.CreateTeacherRequestDto;
import com.example.success_tutor.domain.teacher.Dto.GetTeacherResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

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
        Teacher teacher = Teacher.toEntity(dto);
        teacherRepository.save(teacher);
    }
}
