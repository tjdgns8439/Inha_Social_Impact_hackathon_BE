package com.example.success_tutor.domain.student;

import com.example.success_tutor.domain.problem.Problem;
import com.example.success_tutor.domain.student.dto.CreateStudentRequestDto;
import com.example.success_tutor.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "name")
    private String name;

    /**
     * 초등학교 1 ~ 6
     * 중학교 7 ~ 9
     * 고등학교 10 ~12
     */
    @Column(name = "grade")
    private int grade;

    @OneToMany(mappedBy = "student")
    private List<Problem> problems;

    public static Student toEntity(CreateStudentRequestDto dto) {
        return Student.builder()
                .name(dto.getName())
                .grade(dto.getGrade())
                .build();
    }
}
