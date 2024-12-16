package com.example.Develop_Me.Service;

import com.example.Develop_Me.Repository.UserRepository;
import com.example.Develop_Me.dto.UserDto;
import com.example.Develop_Me.entity.Category;
import com.example.Develop_Me.entity.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MypageServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private CategoryService categoryService;
    @Mock
    private UserService userService;

    @InjectMocks
    private MypageService mypageService;

    private Users user;
    private Category category;
    private UserDto userDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


        category = new Category(1L, "Backend");

        // Mocked entities and DTOs
        user = new Users(1L,"test@example.com","testUser","testUser","java",category);
        user.setUserId(1L);
        user.setNickname("testUser");
        user.setEmail("test@example.com");
        user.setTech("Java");

        userDto = new UserDto();
        userDto.setUserId(1L);
        userDto.setNickname("testUser");
        userDto.setEmail("test@example.com");
        userDto.setTech("Java");
        userDto.setCategoryId(1L);
    }

    @Test
    void testGetUserInfo() {
        // Mocking the userService's behavior
        when(userService.getUserById(1L)).thenReturn(user);

        // Test if the service correctly retrieves user info
        Users retrievedUser = mypageService.getUserInfo(1L);

        assertNotNull(retrievedUser);
        assertEquals(1L, retrievedUser.getUserId());
        assertEquals("testUser", retrievedUser.getNickname());
    }

    @Test
    void testUpdateUserInfo() {
        // Mocking the categoryService's behavior
        when(categoryService.findByCategoryId(1L)).thenReturn(category);

        // Mocking the userService's behavior for the update
        when(userService.updateUser(1L, userDto)).thenReturn(user);

        // Test updating user info
        mypageService.updateUserInfo(user, userDto);

        // Verifying interactions
        verify(userService, times(1)).updateUser(1L, userDto);
    }

    @Test
    void testIsNicknameDuplicate() {
        // Mocking the repository's behavior
        when(userRepository.existsByNickname("testUser")).thenReturn(true);

        // Test nickname duplication check
        boolean isDuplicate = mypageService.isNicknameDuplicate("testUser");

        assertTrue(isDuplicate);

        // Verifying interaction with repository
        verify(userRepository, times(1)).existsByNickname("testUser");
    }

    @Test
    void testIsNicknameNotDuplicate() {
        // Mocking the repository's behavior
        when(userRepository.existsByNickname("newNickname")).thenReturn(false);

        // Test nickname duplication check
        boolean isDuplicate = mypageService.isNicknameDuplicate("newNickname");

        assertFalse(isDuplicate);

        // Verifying interaction with repository
        verify(userRepository, times(1)).existsByNickname("newNickname");
    }
}
