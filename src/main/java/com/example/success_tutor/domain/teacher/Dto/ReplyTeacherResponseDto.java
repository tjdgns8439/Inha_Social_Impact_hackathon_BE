package com.example.success_tutor.domain.teacher.Dto;

import com.example.success_tutor.domain.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Reply에 나타나는 teacher에 대한 DTO
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ReplyTeacherResponseDto {

    // 답변란에 teacher id는 사용하지 않으니 제외
    //private Long teacherId;

    private String name;

    private String school;

    private int prob_num;

    private double rating;

    // 목록에 reply는 필요하지 않으므로 제외
    // private List<Reply> replies;

    public static ReplyTeacherResponseDto toDto(Teacher entity){
        return ReplyTeacherResponseDto.builder()
                .name(entity.getName())
                .school(entity.getSchool())
                .prob_num(entity.getProb_num())
                .rating(entity.getRating())
                .build();
    }
}
