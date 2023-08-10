package com.example.success_tutor.domain.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentRequestDto {

    private String name;
    private int grade;
    private String phoneNum;
}