
package com.example.Develop_Me.dto;

import com.example.Develop_Me.entity.Category;
import com.example.Develop_Me.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long userId;
    private String email;
    private String nickname;
    private String tech;
    private Long categoryId; // Category ID만 포함

    // 정적 팩토리 메서드로 엔티티에서 DTO로 변환
    public static UserDto fromEntity(Users user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .tech(user.getTech())
                .categoryId(user.getCategory() != null ? user.getCategory().getCateId() : null)
                .build();
    }

    // 정적 메서드로 DTO에서 엔티티로 변환
    public Users toEntity(Category category) {
        return Users.builder()
                .userId(this.userId)
                .email(this.email)
                .nickname(this.nickname)
                .tech(this.tech)
                .category(category)
                .build();
    }

    // Users 엔티티의 정보 업데이트 메소드
    public void updateUserInfo(Users user, String nickname, String tech, Category category) {
        if (this.email != null) {
            user.setEmail(this.email); // 이메일 업데이트
        }
        if (this.nickname != null) {
            user.setNickname(nickname); // 닉네임 업데이트
        }
        if (this.tech != null) {
            user.setTech(tech); // 기술 정보 업데이트
        }
        if (category != null) {
            user.setCategory(category); // 카테고리 정보 업데이트
        }
    }
}

