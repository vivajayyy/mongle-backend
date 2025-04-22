package com.mongle.monglebackend.service;

import com.mongle.monglebackend.dto.request.child.ChildCreateRequestDto;
import com.mongle.monglebackend.dto.request.child.ChildUpdateRequestDto;
import com.mongle.monglebackend.dto.response.child.ChildResponseDto;

import java.util.List;

public interface ChildService {

    /**
     * 부모 ID를 기준으로 아이를 등록합니다.
     * @param userId 부모의 사용자 ID
     * @param dto 아이 등록 요청 정보
     */
    void createChild(Long userId, ChildCreateRequestDto dto);

    /**
     * 아이 ID로 아이 정보를 조회합니다.
     * @param childId 아이 ID
     * @return 조회된 아이 정보
     */
    ChildResponseDto findChild(Long childId);

    /**
     * 특정 사용자 ID에 속한 모든 아이 정보를 조회합니다.
     * @param userId 사용자 ID
     * @return 아이 리스트
     */
    List<ChildResponseDto> findChildrenByUser(Long userId);

    /**
     * 아이 ID를 기준으로 정보를 수정합니다.
     * @param childId 아이 ID
     * @param dto 수정할 정보
     */
    void updateChild(Long childId, ChildUpdateRequestDto dto);

    /**
     * 아이 ID를 기준으로 해당 아이를 삭제합니다.
     * @param childId 아이 ID
     */
    void deleteChild(Long childId);
}
