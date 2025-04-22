package com.mongle.monglebackend.service.impl;

import com.mongle.monglebackend.domain.entity.User;
import com.mongle.monglebackend.domain.repository.UserRepository;
import com.mongle.monglebackend.dto.request.user.UserCreateRequestDto;
import com.mongle.monglebackend.dto.request.user.UserUpdateRequestDto;
import com.mongle.monglebackend.service.UserService;
import com.mongle.monglebackend.exception.ResourceNotFoundException;
import com.mongle.monglebackend.exception.InvalidInputException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void saveUser(UserCreateRequestDto dto) {
        if (dto.getEmail() == null || dto.getEmail().isEmpty()) {
            throw new InvalidInputException("이메일은 필수 입력 사항입니다.");
        }
        User user = User.builder()
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .isSocialLogin(dto.isSocialLogin())
                .build();
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    @Override
    @Transactional(readOnly = true)
    public java.util.List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void updateUser(Long id, UserUpdateRequestDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        user.updateNickname(dto.getNickname());
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User", "id", id);
        }
        userRepository.deleteById(id);
    }
}