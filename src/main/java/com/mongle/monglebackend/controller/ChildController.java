package com.mongle.monglebackend.controller;

import com.mongle.monglebackend.dto.request.child.ChildCreateRequestDto;
import com.mongle.monglebackend.dto.request.child.ChildUpdateRequestDto;
import com.mongle.monglebackend.dto.response.child.ChildResponseDto;
import com.mongle.monglebackend.service.ChildService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/children")
@RequiredArgsConstructor
public class ChildController {

    private final ChildService childService;

    /**
     * 아이를 등록하는 API
     * @param userId 부모의 사용자 ID
     * @param dto 아이 등록 정보
     * @return HTTP 상태 200 (OK)
     */
    @PostMapping
    public ResponseEntity<Void> createChild(@RequestParam Long userId, @RequestBody ChildCreateRequestDto dto) {
        childService.createChild(userId, dto);
        return ResponseEntity.ok().build();
    }

    /**
     * 아이 단건 조회 API
     * @param childId 아이 ID
     * @return 아이 정보 (HTTP 상태 200)
     */
    @GetMapping("/{childId}")
    public ResponseEntity<ChildResponseDto> getChild(@PathVariable Long childId) {
        ChildResponseDto child = childService.findChild(childId);
        return ResponseEntity.ok(child);
    }

    /**
     * 특정 부모의 모든 아이 조회 API
     * @param userId 부모 ID
     * @return 아이 목록 (HTTP 상태 200)
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ChildResponseDto>> getChildrenByUser(@PathVariable Long userId) {
        List<ChildResponseDto> children = childService.findChildrenByUser(userId);
        return ResponseEntity.ok(children);
    }

    /**
     * 아이 정보 수정 API
     * @param childId 아이 ID
     * @param dto 수정할 아이 정보
     * @return HTTP 상태 200 (OK)
     */
    @PutMapping("/{childId}")
    public ResponseEntity<Void> updateChild(@PathVariable Long childId, @RequestBody ChildUpdateRequestDto dto) {
        childService.updateChild(childId, dto);
        return ResponseEntity.ok().build();
    }

    /**
     * 아이 삭제 API
     * @param childId 아이 ID
     * @return HTTP 상태 204 (No Content)
     */
    @DeleteMapping("/{childId}")
    public ResponseEntity<Void> deleteChild(@PathVariable Long childId) {
        childService.deleteChild(childId);
        return ResponseEntity.noContent().build();
    }
}
