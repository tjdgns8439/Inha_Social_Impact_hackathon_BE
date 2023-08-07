package com.example.success_tutor.domain.student;

import com.example.success_tutor.domain.student.dto.CreateStudentRequestDto;
import com.example.success_tutor.global.BaseEntity;
import com.sun.source.tree.MemberSelectTree;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id){
        return new ResponseEntity<>(studentService.findStudent(id),HttpStatus.FOUND);
    }

    @PostMapping()
    public ResponseEntity<?> createStudent(@RequestBody CreateStudentRequestDto dto){
        studentService.createStudent(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
