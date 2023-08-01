package com.example.success_tutor.domain.problem;

import com.example.success_tutor.domain.student.Student;
import com.example.success_tutor.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Problem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long problemId;

    @Column(name = "content")
    private String content;

    @Column(name = "picture")
    private String picture;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

}
