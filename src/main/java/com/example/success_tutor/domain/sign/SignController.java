package com.example.success_tutor.domain.sign;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign")
@RequiredArgsConstructor
public class SignController {

    private final SignService signService;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto dto){
        LoginResponseDto login = signService.login(dto);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }
}
