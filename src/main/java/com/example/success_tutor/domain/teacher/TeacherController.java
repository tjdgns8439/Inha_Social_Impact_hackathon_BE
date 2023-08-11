package com.example.success_tutor.domain.teacher;

import com.example.success_tutor.domain.teacher.Dto.CreateTeacherRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping()
    public ResponseEntity<?> createTeacher(@RequestBody CreateTeacherRequestDto dto) {
        teacherService.createTeacher(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getTeacher() {
        return new ResponseEntity<>(teacherService.GetTeacherResponseDto(),HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTeacher(@PathVariable Long id){
        return new ResponseEntity<>(teacherService.findByIdTeacher(id),HttpStatus.FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
        return new ResponseEntity<>("id: "+id+"번이 삭제되었습니다.", HttpStatus.OK);
    }
}
