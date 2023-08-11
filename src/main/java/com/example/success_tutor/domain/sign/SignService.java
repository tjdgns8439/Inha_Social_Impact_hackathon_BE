package com.example.success_tutor.domain.sign;

import com.example.success_tutor.domain.student.Student;
import com.example.success_tutor.domain.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignService {

    private final StudentRepository studentRepository;

    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginRequestDto dto) {
        Student find = studentRepository.findByPhoneNum(dto.getPhoneNum()).get();

        //못찾으면 예외처리
        if (find == null) {
            throw new RuntimeException("못찾음");
        }

        if (!passwordEncoder.matches(dto.getPassword(), find.getPassword())) {
            throw new RuntimeException("패스워드 일치 안함");
        }

        if(find.getToken()==null){
            throw new RuntimeException("토큰 없음");
        }

        return LoginResponseDto.toDto(find.getToken());
    }


}
