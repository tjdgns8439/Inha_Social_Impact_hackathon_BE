package com.example.success_tutor.domain.reply;


import com.example.success_tutor.domain.problem.Problem;
import com.example.success_tutor.domain.reply.dto.CreateReplyRequestDto;
import com.example.success_tutor.domain.teacher.Teacher;
import com.example.success_tutor.global.BaseEntity;
import com.example.success_tutor.global.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
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

    @Column(name = "video")
    private String video;

    @Column(name = "status")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problemI-_id")
    private Problem problem;

    public static Reply toEntity(CreateReplyRequestDto dto,Problem problem,Teacher teacher) {
        return Reply.builder()
                .content(dto.getContent())
                .video(dto.getVideo())
                .status(Status.ADOPTED)
                .problem(problem)
                .teacher(teacher)
                .build();
    }
}
