package com.example.Develop_Me.Service;

import com.example.Develop_Me.Repository.CategoryRepository;
import com.example.Develop_Me.Repository.UserRepository;
import com.example.Develop_Me.dto.UserJoinDto;
import com.example.Develop_Me.entity.Category;
import com.example.Develop_Me.entity.Users;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class UserService  {
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, CategoryRepository categoryRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Long save(UserJoinDto dto) {
        Category category = categoryRepository.findByCateId(dto.getCategoryId())
                .orElse(new Category(dto.getCategoryId())); // 카테고리 ID로 새로운 카테고리 생성

        Category savedCategory = categoryRepository.save(category);

        return userRepository.save(Users.builder()
                .userId(dto.getUserId())
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword())) // 비밀번호 인코딩
                .nickname(dto.getNickname())
                .tech(dto.getTech())
                .category(savedCategory) // savedCategory로 설정
                .build()).getUserId();
    }

}
