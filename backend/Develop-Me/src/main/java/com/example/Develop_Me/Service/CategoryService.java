package com.example.Develop_Me.Service;

import com.example.Develop_Me.Repository.CategoryRepository;
import com.example.Develop_Me.dto.CategoryDto;
import com.example.Develop_Me.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category findByCategoryId(Long CategoryId) {
        return categoryRepository.findById(CategoryId)
                .orElseThrow(() -> new IllegalArgumentException("카테고리를 찾을 수 없습니다."));
    }
}
