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

    /**
     * @methodName : getProblem
     * @param :@PathVariable Long id - Problem의 id
     * @return : 해당 id의 문제 엔티티를 반환합니다.
     * @Description:
     * @note:
     **/
    @GetMapping("/{id}")
    public ResponseEntity<?> getProblem(@PathVariable Long id) {
        return new ResponseEntity<>(problemService.getProblem(id), HttpStatus.OK);
    }

    /**
    * @methodName : postProblem
    * @param : roblemRequestDto requestDto
    * @return : 
    * @Description: roblemRequestDto requestDto를 받아 저장합니다
    * @note:
    **/
    @PostMapping()
    public ResponseEntity<?> postProblem(@RequestBody ProblemRequestDto dto) {
        problemService.postProblem(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * @methodName : updateProblem
     * @param :
     * @return :
     * @Description:
     * @note:
     **/
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateProblem(@PathVariable("id") Long id, @RequestBody ProblemRequestDto historyRequestDto) {
        problemService.updateProblem(id, historyRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * @methodName : deleteProblem
     * @param :
     * @return :
     * @Description:
     * @note:
     **/
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProblem(@PathVariable("id") Long id) {
        problemService.deleteProblem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
