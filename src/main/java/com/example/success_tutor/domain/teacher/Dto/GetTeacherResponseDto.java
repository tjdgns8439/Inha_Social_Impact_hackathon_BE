package com.example.success_tutor.domain.teacher.Dto;

import com.example.success_tutor.domain.reply.Reply;
import com.example.success_tutor.domain.teacher.Teacher;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetTeacherResponseDto {

    private Long teacherId;

    private String name;

    private String school;

    private String major;

    private int prob_num;

    private String phoneNum;

    private double rating;


    // 목록에 reply는 필요하지 않으므로 제외
    // private List<Reply> replies;


    public static GetTeacherResponseDto toDto(Teacher entity) {
        return GetTeacherResponseDto.builder()
                .teacherId(entity.getTeacherId())
                .name(entity.getName())
                .school(entity.getSchool())
                .major(entity.getMajor())
                .prob_num(entity.getProb_num())
                .phoneNum(entity.getPhoneNum())
                .rating(entity.getRating())
                .build();
    }
}
