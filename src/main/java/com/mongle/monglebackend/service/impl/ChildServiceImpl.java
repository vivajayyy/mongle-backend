package com.mongle.monglebackend.service.impl;

import com.mongle.monglebackend.domain.entity.Child;
import com.mongle.monglebackend.domain.entity.GenderType;
import com.mongle.monglebackend.domain.entity.User;
import com.mongle.monglebackend.domain.repository.ChildRepository;
import com.mongle.monglebackend.domain.repository.UserRepository;
import com.mongle.monglebackend.dto.request.child.ChildCreateRequestDto;
import com.mongle.monglebackend.dto.request.child.ChildUpdateRequestDto;
import com.mongle.monglebackend.dto.response.child.ChildResponseDto;
import com.mongle.monglebackend.service.ChildService;
import com.mongle.monglebackend.exception.ResourceNotFoundException;
import com.mongle.monglebackend.exception.InvalidInputException;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChildServiceImpl implements ChildService {

    private final ChildRepository childRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void createChild(Long userId, ChildCreateRequestDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        if (dto.getName() == null || dto.getName().isEmpty()) {
            throw new InvalidInputException("아이 이름은 필수 입력 사항입니다.");
        }

        Child child = Child.builder()
                .name(dto.getName())
                .birthDate(LocalDate.parse(dto.getBirthDate()))
                .gender(GenderType.valueOf(dto.getGender()))
                .user(user)  // 부모 연결
                .build();

        childRepository.save(child);
    }

    @Override
    @Transactional(readOnly = true)
    public ChildResponseDto findChild(Long childId) {
        Child child = childRepository.findById(childId)
                .orElseThrow(() -> new ResourceNotFoundException("Child", "id", childId));

        return new ChildResponseDto(child.getId(), child.getName(), child.getBirthDate(), child.getGender());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ChildResponseDto> findChildrenByUser(Long userId) {
        List<Child> children = childRepository.findByUserId(userId);

        if (children.isEmpty()) {
            throw new ResourceNotFoundException("Child", "user_id", userId);
        }

        return children.stream()
                .map(child -> new ChildResponseDto(child.getId(), child.getName(), child.getBirthDate(), child.getGender()))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateChild(Long childId, ChildUpdateRequestDto dto) {
        Child child = childRepository.findById(childId)
                .orElseThrow(() -> new ResourceNotFoundException("Child", "id", childId));

        if (dto.getName() == null || dto.getName().isEmpty()) {
            throw new InvalidInputException("아이 이름은 필수 입력 사항입니다.");
        }

        child.updateNickname(dto.getName());
        childRepository.save(child);
    }

    @Override
    @Transactional
    public void deleteChild(Long childId) {
        if (!childRepository.existsById(childId)) {
            throw new ResourceNotFoundException("Child", "id", childId);
        }
        childRepository.deleteById(childId);
    }
}