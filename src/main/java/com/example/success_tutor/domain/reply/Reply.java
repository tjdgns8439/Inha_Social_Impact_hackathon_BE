package com.example.success_tutor.domain.reply;


import com.example.success_tutor.domain.problem.Problem;
import com.example.success_tutor.domain.teacher.Teacher;
import com.example.success_tutor.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;

    @Column(name = "content")
    private String content;

    @Column(name = "rating")
    private double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacherId")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problemId")
    private Problem problem;
}
