package com.example.success_tutor.domain.problem;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProblemService {
    private final ProblemRepository problemRepository;


}
