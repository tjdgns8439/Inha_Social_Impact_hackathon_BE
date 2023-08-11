package com.example.success_tutor.domain.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository

public interface StudentRepository extends JpaRepository<Student, Long> {

    Boolean existsByPhoneNum(String phoneNum);

    Optional<Student> findByPhoneNum(String phoneNum);

}
