package com.example.success_tutor.domain.problem.dto;

import com.example.success_tutor.domain.problem.Problem;
import com.example.success_tutor.domain.reply.Reply;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProblemResponseDto {

    private Long problemId;
    private String content;
    private String picture;
    private Long studentId;
    private List<Reply> replies;
}