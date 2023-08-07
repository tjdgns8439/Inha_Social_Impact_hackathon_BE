package com.example.success_tutor.domain.problem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProblemRequestDto {

    private String content;

    private String picture;

    private Long studentId;
}