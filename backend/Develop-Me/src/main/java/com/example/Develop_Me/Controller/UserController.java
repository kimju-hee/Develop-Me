package com.example.Develop_Me.Controller;

import com.example.Develop_Me.Service.UserService;
import com.example.Develop_Me.dto.UserJoinDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/signup")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Long> registerUser(@RequestBody UserJoinDto userJoinDto) {
        Long userId = userService.save(userJoinDto);
        return new ResponseEntity<>(userId, HttpStatus.CREATED);
    }
}
