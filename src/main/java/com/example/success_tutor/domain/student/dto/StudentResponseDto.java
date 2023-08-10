package com.example.success_tutor.domain.student.dto;

import com.example.success_tutor.domain.problem.Problem;
import com.example.success_tutor.domain.student.Student;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {

    private String name;
    private int grade;
    private String phoneNum;

    public static StudentResponseDto toDto(Student entity){
        return StudentResponseDto.builder()
                .name(entity.getName())
                .grade(entity.getGrade())
                .phoneNum(entity.getPhoneNum())
                .build();
    }
}