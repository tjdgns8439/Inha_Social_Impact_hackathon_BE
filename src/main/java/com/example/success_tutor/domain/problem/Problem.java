package com.example.success_tutor.domain.problem;

import com.example.success_tutor.domain.problem.dto.ProblemRequestDto;
import com.example.success_tutor.domain.reply.Reply;
import com.example.success_tutor.domain.student.Student;
import com.example.success_tutor.global.BaseEntity;
import com.example.success_tutor.global.Status;
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

    //문제의 내용
    @Column(name = "content")
    private String content;

    //문제의 사진
    @Column(name = "picture")
    private String picture;

    //채택 상태
    @Column(name = "status")
    private Status status;

    //작성자 정보
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;

    //답글 리스트
    @OneToMany(mappedBy = "problem")
    private List<Reply> replies;

    public static Problem toProblem(ProblemRequestDto dto, Student student){
        return Problem.builder()
                .content(dto.getContent())
                .picture(dto.getPicture())
                .status(Status.NotAdopted)
                .student(student)
                .build();
    }

    public void update(ProblemRequestDto problemRequestDto) {
        this.content = problemRequestDto.getContent();
        this.picture = problemRequestDto.getPicture();
    }

}
