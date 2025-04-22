package com.mongle.monglebackend.dto.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "사용자 정보 수정 요청 DTO")
public class UserUpdateRequestDto {

    @Schema(description = "수정할 닉네임", example = "몽글아빠")
    private String nickname;
}
