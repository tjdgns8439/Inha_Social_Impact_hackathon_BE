package com.example.success_tutor.domain.student;

import com.example.success_tutor.global.BaseEntity;
import com.sun.source.tree.MemberSelectTree;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentRepository studentRepository;

}
