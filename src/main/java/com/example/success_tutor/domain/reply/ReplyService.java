package com.example.success_tutor.domain.reply;

import com.example.success_tutor.domain.problem.Problem;
import com.example.success_tutor.domain.problem.ProblemRepository;
import com.example.success_tutor.domain.reply.dto.CreateReplyRequestDto;
import com.example.success_tutor.domain.teacher.Teacher;
import com.example.success_tutor.domain.teacher.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    private final ProblemRepository problemRepository;

    private final TeacherRepository teacherRepository;

    @Transactional
    public void createReply(CreateReplyRequestDto dto) {
        Optional<Problem> findedProblem = problemRepository.findById(dto.getProblem_id());
        Optional<Teacher> findedTeacher = teacherRepository.findById(dto.getTeacher_id());
        
        Reply entity = Reply.toEntity(dto, findedProblem.get(), findedTeacher.get());
        replyRepository.save(entity);
    }
}
