package com.example.success_tutor.global.exception.teacher;

import com.example.success_tutor.global.exception.CustomException;
import com.example.success_tutor.global.exception.ErrorCode;

public class TeacherPhoneAlreadyExistsException extends CustomException {
    public TeacherPhoneAlreadyExistsException(){
        super(ErrorCode.PHONE_NUM_ALREADY_EXISTS);
    }
}
