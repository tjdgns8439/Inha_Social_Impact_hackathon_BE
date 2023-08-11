package com.example.success_tutor.global.exception.teacher;

import com.example.success_tutor.global.exception.CustomException;
import com.example.success_tutor.global.exception.ErrorCode;

public class TeacherNotFoundException extends CustomException {
    public TeacherNotFoundException(){
        super(ErrorCode.USER_NOT_FOUND);
    }
}
