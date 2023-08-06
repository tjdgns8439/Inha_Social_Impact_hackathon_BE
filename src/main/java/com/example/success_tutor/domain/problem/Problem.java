package com.example.success_tutor.domain.problem;

import com.example.success_tutor.domain.problem.dto.ProblemRequestDto;
import com.example.success_tutor.domain.reply.Reply;
import com.example.success_tutor.domain.student.Student;
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
public class Problem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long problemId;

    @Column(name = "content")
    private String content;

    @Column(name = "picture")
    private String picture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;

    @OneToMany(mappedBy = "problem")
    private List<Reply> replies;

    public static Problem toProblem(ProblemRequestDto dto){
        return Problem.builder()
                .content(dto.getContent())
                .picture(dto.getPicture())
                .build();
    }

}
