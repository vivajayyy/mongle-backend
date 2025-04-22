package com.mongle.monglebackend.service;

import com.mongle.monglebackend.domain.entity.User;
import com.mongle.monglebackend.dto.request.user.UserCreateRequestDto;
import com.mongle.monglebackend.dto.request.user.UserUpdateRequestDto;
import java.util.List;

public interface UserService {

    void saveUser(UserCreateRequestDto dto);

    User findUserById(Long id);

    List<User> findAllUsers();

    void updateUser(Long id, UserUpdateRequestDto dto);

    void deleteUser(Long id);
}
