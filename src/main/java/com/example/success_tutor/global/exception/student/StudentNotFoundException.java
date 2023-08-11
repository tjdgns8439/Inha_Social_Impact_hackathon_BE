package com.example.success_tutor.global.exception.student;

import com.example.success_tutor.global.exception.CustomException;
import com.example.success_tutor.global.exception.ErrorCode;

public class StudentNotFoundException extends CustomException {
    public StudentNotFoundException(){
        super(ErrorCode.USER_NOT_FOUND);
    }
}
