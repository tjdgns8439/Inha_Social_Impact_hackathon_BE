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

    //핸드폰번호, 중복가입 제거 식별자
    //유일 식별 값 되야함
    @Column(name = "phoneNum", nullable = false)
    private String phoneNum;

    @Column(name = "password")
    private String password;

    //유일 식별 값 되야함
    @Column(name = "token")
    private String token;

    @OneToMany(mappedBy = "student")
    private List<Problem> problems;

    public static Student toEntity(CreateStudentRequestDto dto,String encodedPassword, String token) {
        return Student.builder()
                .name(dto.getName())
                .phoneNum(dto.getPhoneNum())
                .grade(dto.getGrade())
                .password(encodedPassword)
                .token(token)
                .build();
    }

}
