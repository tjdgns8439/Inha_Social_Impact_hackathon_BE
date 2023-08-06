package com.example.success_tutor.domain.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {
    private Long studentId;
    private String name;
    private int grade;
}