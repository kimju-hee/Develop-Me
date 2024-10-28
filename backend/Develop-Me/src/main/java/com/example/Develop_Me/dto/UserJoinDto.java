package com.example.Develop_Me.dto;

import com.example.Develop_Me.entity.Users;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserJoinDto {
    private Long userId;
    private String email;
    private String password;
    private String nickname;
    private String tech;
    private Long categoryId;

    @Builder
    public UserJoinDto(Long userId, String email, String password, String nickname, String tech, Long categoryId) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.tech = tech;
        this.categoryId = categoryId;
    }

    public Users toEntity() {
        return Users.builder()
                .userId(userId)
                .email(email)
                .password(password)
                .nickname(nickname)
                .tech(tech)
                .build();
    }
}
