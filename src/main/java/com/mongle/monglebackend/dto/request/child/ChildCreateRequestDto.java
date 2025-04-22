package com.mongle.monglebackend.dto.request.child;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 아이 생성 요청을 위한 DTO 클래스입니다.
 * 요청 본문으로 아이의 정보를 받습니다.
 */
@Getter
@Setter
@Schema(description = "아이 생성 요청 DTO")
public class ChildCreateRequestDto {

    @Schema(description = "아이의 이름", example = "몽글아기")
    private String name;

    @Schema(description = "아이의 생년월일", example = "2023-05-01")
    private String birthDate;

    @Schema(description = "아이의 성별", example = "MALE")
    private String gender;
}