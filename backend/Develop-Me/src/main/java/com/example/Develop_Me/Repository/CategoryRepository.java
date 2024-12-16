package com.example.Develop_Me.Repository;

import com.example.Develop_Me.entity.Category;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCateId(Long categoryId);
}
