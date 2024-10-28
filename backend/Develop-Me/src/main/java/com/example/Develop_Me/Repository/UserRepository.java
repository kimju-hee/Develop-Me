package com.example.Develop_Me.Repository;

import com.example.Develop_Me.entity.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUserId(Long userId);
}
