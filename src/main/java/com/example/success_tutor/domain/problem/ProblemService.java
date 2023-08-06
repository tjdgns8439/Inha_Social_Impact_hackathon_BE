package com.example.success_tutor.domain.problem;

import com.example.success_tutor.domain.problem.dto.ProblemRequestDto;
import com.example.success_tutor.domain.problem.dto.ProblemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProblemService {
    private final ProblemRepository problemRepository;


    @Transactional
    public ProblemResponseDto getProblem(Long problemId) {
        Optional<Problem> problem = problemRepository.findById(problemId);
        ProblemResponseDto responseDto = new ProblemResponseDto();
        BeanUtils.copyProperties(problem, responseDto);
        return responseDto;
    }

    @Transactional
    public Problem postProblem(ProblemRequestDto dto) {
        Problem problem = Problem.toProblem(dto);
        return problemRepository.save(problem);
    }


    @Transactional
    public void deleteProblem(Long id) {
        problemRepository.deleteById(id);
    }

    @Transactional
    public void updateProblem(Long id, ProblemRequestDto problemRequestDto) {
        Problem problem = problemRepository.findById(id).orElseThrow();
        problem.update(problemRequestDto);
    }
}
