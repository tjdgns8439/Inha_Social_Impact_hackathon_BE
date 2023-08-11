package com.example.success_tutor.global.exception.problem;

import com.example.success_tutor.global.exception.CustomException;
import com.example.success_tutor.global.exception.ErrorCode;

public class ProblemNotFoundException extends CustomException {
    public ProblemNotFoundException(){
        super(ErrorCode.PROBLEM_NOT_FOUND);
    }
}
