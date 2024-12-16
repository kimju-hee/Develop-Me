package com.example.Develop_Me.Service;

import com.example.Develop_Me.Repository.UserRepository;
import com.example.Develop_Me.dto.UserDto;
import com.example.Develop_Me.entity.Category;
import com.example.Develop_Me.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MypageService {

    private final UserService userService;
    private final CategoryService categoryService;
    private final UserRepository userRepository;  // 추가된 repository

    // 사용자 정보 조회
    public Users getUserInfo(Long userId) {
        return userService.getUserById(userId);
    }

    // 사용자 정보 업데이트
    public void updateUserInfo(Users user, UserDto userDto) {
        // 카테고리가 있다면 찾아서 설정
        Category category = null;
        if (userDto.getCategoryId() != null) {
            category = categoryService.findByCategoryId(userDto.getCategoryId());
        }

        // DTO에서 받은 정보로 업데이트
        userDto.updateUserInfo(user, userDto.getNickname(), userDto.getTech(), category);
        userService.updateUser(user.getUserId(), userDto);
    }

    // 닉네임 중복 확인
    public boolean isNicknameDuplicate(String nickname) {
        return userRepository.existsByNickname(nickname);  // 닉네임이 중복되면 true 반환
    }
}
