package com.example.Develop_Me.Service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


import com.example.Develop_Me.dto.UserJoinDto;
import com.example.Develop_Me.entity.Category;
import com.example.Develop_Me.entity.Users;
import com.example.Develop_Me.Repository.CategoryRepository;
import com.example.Develop_Me.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void save_ShouldSaveUser_WhenCategoryExists() {
        // Given
        UserJoinDto dto = new UserJoinDto(1L, "email@example.com", "password", "nickname", "tech", 1L);
        Category existingCategory = new Category(1L);
        Users user = Users.builder()
                .userId(1L)
                .email("email@example.com")
                .password("encodedPassword")
                .nickname("nickname")
                .tech("tech")
                .category(existingCategory)
                .build();

        when(categoryRepository.findByCateId(any(Long.class))).thenReturn(Optional.of(existingCategory));
        when(bCryptPasswordEncoder.encode(any(String.class))).thenReturn("encodedPassword");
        when(userRepository.save(any(Users.class))).thenReturn(user);

        // When
        Long userId = userService.save(dto);

        // Then
        verify(categoryRepository).findByCateId(dto.getCategoryId());
        verify(userRepository).save(any(Users.class));
        assertEquals(user.getUserId(), userId);
    }
}
