package com.example.success_tutor.domain.teacher;

import com.example.success_tutor.domain.reply.Reply;
import com.example.success_tutor.domain.teacher.Dto.CreateTeacherRequestDto;
import com.example.success_tutor.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;

    @Column(name = "name")
    private String name;

    @Column(name = "school")
    private String school;

    @Column(name = "major")
    private String major;

    @Column(name = "prob_num")
    private int prob_num;

    @Column(name = "rating")
    private double rating;

    @Column(name = "phoneNum")
    private String phoneNum;

    @OneToMany(mappedBy = "teacher")
    private List<Reply> replies;
    
    public static Teacher toEntity(CreateTeacherRequestDto dto){
        return Teacher.builder()
                .name(dto.getName())
                .school(dto.getSchool())
                .major(dto.getMajor())
                .phoneNum(dto.getPhoneNum())
                .build();
    }
}
