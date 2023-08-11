package com.example.success_tutor.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    //선생, 학생 공통
    //선생, 학생 중복 가입(완)
    PHONE_NUM_ALREADY_EXISTS(HttpStatus.UNAUTHORIZED, "ST001","이미 존재하는 번호입니다."),

    //조회 실패(완) - 선생, 학생
    //삭제 실패(완) - 선생, 학생
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "ST002", "사용자를 찾을 수 없습니다."),

    //인증실패 - 이메일이나 번호 인증(미완) -> 로직도 안짬.
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "ST003", "인증에 실패했습니다."),
    //권한부족 - 인증 안 된 상태에서 활동하려할 때(미완) -> 위와 엮여있음.
    ROLE_NOT_EXISTS(HttpStatus.UNAUTHORIZED, "ST004", "권한이 부족합니다."),

    //문제 조회 실패(미완)
    PROBLEM_NOT_FOUND(HttpStatus.NOT_FOUND, "P001", "문제를 찾을 수 없습니다.");

    //500(미완)
    //INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON-001", "서버에서 처리할 수 없습니다."),

    private HttpStatus status;
    private String code;
    private String message;

    ErrorCode(HttpStatus status, String code, String message){
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
