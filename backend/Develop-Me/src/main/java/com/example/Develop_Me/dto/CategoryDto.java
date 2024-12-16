package com.example.Develop_Me.dto;

import com.example.Develop_Me.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

    private Long cateId;
    private String cateName;

    // 정적 팩토리 메서드로 엔티티에서 DTO로 변환
    public static CategoryDto fromEntity(Category category) {
        return CategoryDto.builder()
                .cateId(category.getCateId())
                .cateName(category.getCateName())
                .build();
    }

    // 정적 메서드로 DTO에서 엔티티로 변환
    public Category toEntity() {
        return new Category(this.cateId, this.cateName);
    }
}
