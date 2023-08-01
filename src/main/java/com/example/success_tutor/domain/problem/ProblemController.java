package com.example.success_tutor.domain.problem;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    ProblemRepository problemRepository;

    @GetMapping("/list")
    public List<Problem> list(){
        return problemRepository.findAll();
    }

}
