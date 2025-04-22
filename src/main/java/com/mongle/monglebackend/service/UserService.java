package com.mongle.monglebackend.service;

import com.mongle.monglebackend.domain.entity.User;
import com.mongle.monglebackend.dto.request.user.UserCreateRequestDto;
import com.mongle.monglebackend.dto.request.user.UserUpdateRequestDto;
import java.util.List;

/**
 * UserService는 사용자 관련 비즈니스 로직을 처리하는 서비스 인터페이스입니다.
 * CRUD 작업을 통해 사용자 데이터를 관리합니다.
 */
public interface UserService {

    /**
     * 새로운 사용자를 저장하는 메서드입니다.
     * @param dto 사용자 생성 정보
     */
    void saveUser(UserCreateRequestDto dto);

    /**
     * 주어진 사용자 ID로 사용자를 조회하는 메서드입니다.
     * @param id 사용자 ID
     * @return 해당 사용자
     */
    User findUserById(Long id);

    /**
     * 모든 사용자를 조회하는 메서드입니다.
     * @return 사용자 목록
     */
    List<User> findAllUsers();

    /**
     * 주어진 사용자 ID와 수정 정보를 바탕으로 사용자를 업데이트하는 메서드입니다.
     * @param id 사용자 ID
     * @param dto 사용자 수정 정보
     */
    void updateUser(Long id, UserUpdateRequestDto dto);

    /**
     * 주어진 사용자 ID로 사용자를 삭제하는 메서드입니다.
     * @param id 사용자 ID
     */
    void deleteUser(Long id);
}
