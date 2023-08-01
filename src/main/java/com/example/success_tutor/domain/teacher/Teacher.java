package com.example.success_tutor.domain.teacher;

import com.example.success_tutor.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(name = "prob_num")
    private int prob_num;

    @Column(name = "rating")
    private double rating;

}
