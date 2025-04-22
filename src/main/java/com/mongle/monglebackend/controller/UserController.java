package com.mongle.monglebackend.controller;

import com.mongle.monglebackend.domain.entity.User;
import com.mongle.monglebackend.dto.request.user.UserCreateRequestDto;
import com.mongle.monglebackend.dto.request.user.UserUpdateRequestDto;
import com.mongle.monglebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController는 사용자와 관련된 HTTP 요청을 처리하는 컨트롤러입니다.
 * CRUD 작업을 통해 사용자 데이터를 관리합니다.
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 새로운 사용자를 생성하는 API
     * @param requestDto 사용자 생성 정보
     * @return HTTP 상태 200 (OK)
     */
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserCreateRequestDto requestDto) {
        userService.saveUser(requestDto);
        return ResponseEntity.ok().build();
    }

    /**
     * 특정 사용자의 정보를 조회하는 API
     * @param id 사용자 ID
     * @return 사용자 정보
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    /**
     * 모든 사용자의 정보를 조회하는 API
     * @return 모든 사용자 목록
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * 특정 사용자의 정보를 수정하는 API
     * @param id 사용자 ID
     * @param dto 사용자 수정 정보
     * @return HTTP 상태 200 (OK)
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody UserUpdateRequestDto dto) {
        userService.updateUser(id, dto);
        return ResponseEntity.ok().build();
    }

    /**
     * 특정 사용자를 삭제하는 API
     * @param id 사용자 ID
     * @return HTTP 상태 204 (No Content)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}