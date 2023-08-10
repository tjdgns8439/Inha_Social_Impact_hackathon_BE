package com.example.success_tutor.global.exception.student;

import com.example.success_tutor.global.exception.CustomException;
import com.example.success_tutor.global.exception.ErrorCode;
import lombok.Getter;


public class StudentPhoneAlreadyExistsException extends CustomException {
    public StudentPhoneAlreadyExistsException(){
        super(ErrorCode.PHONE_NUM_ALREADY_EXISTS);

    }
}
