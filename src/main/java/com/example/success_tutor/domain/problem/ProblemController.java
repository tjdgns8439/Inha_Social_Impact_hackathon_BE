package com.example.success_tutor.domain.problem;

import com.example.success_tutor.domain.problem.dto.ProblemRequestDto;
import com.example.success_tutor.domain.problem.dto.ProblemResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/problem")
public class ProblemController {

    private final ProblemService problemService;

    @PostMapping("/")// 경로를 지정하지 않음
    public ResponseEntity<?> postProblem(@RequestBody ProblemRequestDto requestDto) {
        return new ResponseEntity<>(problemService.postProblem(requestDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProblem(@PathVariable Long id) {
        return new ResponseEntity<>(problemService.getProblem(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProblem(@PathVariable("id") Long id) {
        problemService.deleteProblem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
