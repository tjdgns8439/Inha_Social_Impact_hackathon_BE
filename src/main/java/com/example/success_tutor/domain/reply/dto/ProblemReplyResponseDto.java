package com.example.success_tutor.domain.reply.dto;

import com.example.success_tutor.domain.problem.Problem;
import com.example.success_tutor.domain.reply.Reply;
import com.example.success_tutor.domain.teacher.Dto.ReplyTeacherResponseDto;
import com.example.success_tutor.domain.teacher.Teacher;
import com.example.success_tutor.global.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Problem에 달리는 Reply에 대한 DTO
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ProblemReplyResponseDto {

    private String content;

    private String video;

    private Status status;

    private ReplyTeacherResponseDto teacher;

    public static ProblemReplyResponseDto toDto(Reply entity) {
        return ProblemReplyResponseDto.builder()
                .content(entity.getContent())
                .video(entity.getVideo())
                .status(entity.getStatus())
                //teacher 반환형으로 보내야함
                .teacher(ReplyTeacherResponseDto.toDto(entity.getTeacher()))
                .build();
    }
}
