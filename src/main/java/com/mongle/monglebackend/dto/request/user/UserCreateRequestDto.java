package com.mongle.monglebackend.dto.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "사용자 생성 요청 DTO")
public class UserCreateRequestDto {

    @Schema(description = "사용자 이메일", example = "user@example.com")
    private String email;

    @Schema(description = "닉네임", example = "몽글맘")
    private String nickname;

    @Schema(description = "소셜 로그인 여부", example = "false")
    private boolean isSocialLogin;
}
