package com.example.success_tutor.domain.problem;

import com.example.success_tutor.domain.problem.dto.ProblemRequestDto;
import com.example.success_tutor.domain.problem.dto.ProblemResponseDto;
import com.example.success_tutor.domain.student.Student;
import com.example.success_tutor.domain.student.StudentRepository;
import com.example.success_tutor.domain.teacher.Dto.GetTeacherResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProblemService {

    private final ProblemRepository problemRepository;

    private final StudentRepository studentRepository;

    /**
     * @param :
     * @return : ProblemResponseDto
     * @methodName : getProblem
     * @Description:
     * @note:
     **/
    @Transactional
    public ProblemResponseDto getProblem(Long problemId) {
        Optional<Problem> problem = problemRepository.findById(problemId);
        return ProblemResponseDto.toDto(problem.get());
    }

    /**
     * @methodName : getProblemListByCategory
     * @param : String category
     * @return : List<ProblemResponseDto>
     * @Description: category(과목이름)로 해당하는 문제 리스트를 뽑아옵니다.
     * @note:
     **/
    @Transactional
    public List<ProblemResponseDto> getProblemListByCategory(String category) {
        List<Problem> problems = problemRepository.findByCategory(category);
        return problems.stream()
                .map(problem -> ProblemResponseDto.toDto(problem))
                .collect(Collectors.toList());
    }

    /**
     * @param : ProblemRequestDto dto
     * @return :
     * @methodName : postProblem
     * @Description: ProblemRequestDto dto를 받아 Problem을 저장합니다.
     * @note:
     **/
    @Transactional
    public void postProblem(ProblemRequestDto dto) {
        Optional<Student> findedStudent = studentRepository.findById(dto.getStudentId());
        Problem problem = Problem.toProblem(dto, findedStudent.get());
        problemRepository.save(problem);
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
