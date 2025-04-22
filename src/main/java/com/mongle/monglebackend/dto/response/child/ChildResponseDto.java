package com.mongle.monglebackend.dto.response.child;

import com.mongle.monglebackend.domain.entity.GenderType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 아이 조회 응답을 위한 DTO 클래스입니다.
 * 아이 정보를 반환할 때 사용됩니다.
 */
@Getter
@Setter
@AllArgsConstructor  // 생성자 추가
@Schema(description = "아이 조회 응답 DTO")
public class ChildResponseDto {

    @Schema(description = "아이 ID", example = "1")
    private Long id;

    @Schema(description = "아이의 이름", example = "몽글아기")
    private String name;

    @Schema(description = "아이의 생년월일", example = "2023-05-01")
    private LocalDate birthDate;

    @Schema(description = "아이의 성별", example = "MALE")
    private GenderType gender;
}