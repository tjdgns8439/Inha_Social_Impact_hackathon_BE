package com.example.success_tutor.domain.problem.dto;

import com.example.success_tutor.domain.problem.Problem;
import com.example.success_tutor.domain.reply.dto.ProblemReplyResponseDto;
import com.example.success_tutor.domain.student.dto.StudentResponseDto;
import com.example.success_tutor.global.Status;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProblemResponseDto {

    private String content;
    private String picture;
    private StudentResponseDto student;
    private Status status;
    private List<ProblemReplyResponseDto> replies;

    public static ProblemResponseDto toDto(Problem entity) {
        ProblemResponseDto buildDto = ProblemResponseDto.builder()
                .content(entity.getContent())
                .picture(entity.getPicture())
                .student(StudentResponseDto.toDto(entity.getStudent()))
                .status(entity.getStatus())
                .replies(entity.getReplies().stream().map(
                        reply -> ProblemReplyResponseDto.toDto(reply)
                ).toList())
                .build();

        return buildDto;
    }
}