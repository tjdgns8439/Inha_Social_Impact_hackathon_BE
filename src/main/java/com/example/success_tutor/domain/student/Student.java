package com.example.success_tutor.domain.student;

import com.example.success_tutor.domain.problem.Problem;
import com.example.success_tutor.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "name")
    private String name;

    @Column(name = "grade")
    private int grade;

    @OneToMany(mappedBy = "student")
    private List<Problem> problems;
}
