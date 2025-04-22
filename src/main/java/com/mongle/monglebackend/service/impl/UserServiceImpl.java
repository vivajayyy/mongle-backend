package com.mongle.monglebackend.service.impl;

import com.mongle.monglebackend.domain.entity.User;
import com.mongle.monglebackend.domain.repository.UserRepository;
import com.mongle.monglebackend.dto.request.user.UserCreateRequestDto;
import com.mongle.monglebackend.dto.request.user.UserUpdateRequestDto;
import com.mongle.monglebackend.service.UserService;
import java.util.List;
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
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void updateUser(Long id, UserUpdateRequestDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        user.updateNickname(dto.getNickname());
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("해당 유저가 존재하지 않습니다.");
        }
        userRepository.deleteById(id);
    }
}