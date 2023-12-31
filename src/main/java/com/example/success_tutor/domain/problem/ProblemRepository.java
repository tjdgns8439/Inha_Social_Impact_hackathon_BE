package com.example.success_tutor.domain.problem;

import com.example.success_tutor.domain.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
    List<Problem> findBySubject(String subject);
    List<Problem> findByGrade(Integer grade);
    List<Problem> findBySubjectAndGrade(String subject,Integer grade);
}
