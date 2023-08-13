package com.example.success_tutor.domain.sign;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

    private String token;


    public static LoginResponseDto toDto(String token) {
        return LoginResponseDto.builder().token(token).build();
    }
}
