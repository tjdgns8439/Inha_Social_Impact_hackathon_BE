package com.example.success_tutor.domain.reply.dto;

import com.example.success_tutor.domain.problem.Problem;
import com.example.success_tutor.domain.teacher.Teacher;
import com.example.success_tutor.global.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateReplyRequestDto {

    private String content;

    private String video;

    private Long teacher_id;

    private Long problem_id;

}
