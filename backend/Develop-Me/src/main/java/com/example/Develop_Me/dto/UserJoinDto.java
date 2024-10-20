package com.example.Develop_Me.dto;

import com.example.Develop_Me.entity.Category;
import com.example.Develop_Me.entity.Users;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserJoinDto {
    private String email;
    private String password;
    private String nickname;
    private String tech;
    private Category category;

    @Builder
    public UserJoinDto(String username, String password, String email, String nickname, String tech, Category category) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.tech = tech;
        this.category = category;
    }

    public Users toEntity(){
        return Users.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .tech(tech)
                .category(category)
                .build();
    }

}
