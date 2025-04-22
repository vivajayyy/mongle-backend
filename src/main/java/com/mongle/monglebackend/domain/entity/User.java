package com.mongle.monglebackend.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nickname;

    @Column(name = "is_social_login", nullable = false)
    private boolean isSocialLogin;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)  // EAGER 로딩
    @JsonManagedReference  // 순환 참조 방지
    private List<Child> children;

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }
}