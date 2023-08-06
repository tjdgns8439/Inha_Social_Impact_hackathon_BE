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

    @PostMapping("/")
    public ResponseEntity<?> postProblem(@RequestBody ProblemRequestDto requestDto) {
        return new ResponseEntity<>(problemService.postProblem(requestDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProblem(@PathVariable Long id) {
        return new ResponseEntity<>(problemService.getProblem(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateProblem(@PathVariable("id") Long id, @RequestBody ProblemRequestDto historyRequestDto) {
        problemService.updateProblem(id, historyRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProblem(@PathVariable("id") Long id) {
        problemService.deleteProblem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
