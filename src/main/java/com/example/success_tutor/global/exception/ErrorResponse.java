package com.example.success_tutor.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

    private String code;
    private String message;
    private HttpStatus httpStatus;

    public ErrorResponse(HttpStatus status, String s) {
        this.message = s;
        this.httpStatus = status;
    }

    public ErrorResponse(ErrorCode code){
        this.message = code.getMessage();
        this.httpStatus = code.getStatus();
        this.code = code.getCode();
    }
}