package com.example.success_tutor.domain.teacher.Dto;

import com.example.success_tutor.domain.reply.Reply;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateTeacherRequestDto {

    //이름
    private String name;

    //학교
    private String school;

    // 초기 생성시 제외
    //private int prob_num;
    //private double rating;
    //private List<Reply> replies;

}
