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
     * @methodName : getProblemListBySubject
     * @param : String subject
     * @return : List<ProblemResponseDto>
     * @Description: subject(과목이름)로 해당하는 문제 리스트를 반환합니다.
     * @note:
     **/
    @Transactional
    public List<ProblemResponseDto> getProblemListBySubject(String subject) {
        List<Problem> problems = problemRepository.findBySubject(subject);
        return problems.stream()
                .map(problem -> ProblemResponseDto.toDto(problem))
                .collect(Collectors.toList());
    }

    /**
     * @methodName : getProblemListByGrade
     * @param : Integer grade
     * @return : List<ProblemResponseDto>
     * @Description: grade(교육과정학년)로 해당하는 문제 리스트를 반환합니다.
     * @note:
     **/
    @Transactional
    public List<ProblemResponseDto> getProblemListByGrade(Integer grade) {
        List<Problem> problems = problemRepository.findByGrade(grade);
        return problems.stream()
                .map(problem -> ProblemResponseDto.toDto(problem))
                .collect(Collectors.toList());
    }

    /**
     * @methodName : getProblemListBySubjectAndGrade
     * @param : Integer grade
     * @return : List<ProblemResponseDto>
     * @Description: subject & grade로 해당하는 문제 리스트를 반환합니다.
     * @note:
     **/
    @Transactional
    public List<ProblemResponseDto> getProblemListBySubjectAndGrade(String subject, Integer grade) {
        List<Problem> problems = problemRepository.findBySubjectAndGrade(subject, grade);
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
