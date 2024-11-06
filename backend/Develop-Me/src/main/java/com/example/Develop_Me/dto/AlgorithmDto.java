package com.example.Develop_Me.dto;

import com.example.Develop_Me.entity.Algorithm;
import com.example.Develop_Me.entity.Users;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlgorithmDto {
    private Long algorithmId;
    private int monthCount;
    private int totalCount;
    private Users usres;

    @Builder
    public AlgorithmDto(Long algorithmId, Integer monthCount, Integer totalCount, Users users){
        this.algorithmId = algorithmId;
        this.monthCount = monthCount;
        this.totalCount = totalCount;
        this.usres = users;
    }

    public Algorithm toEntity() {
        return Algorithm.builder()
                .algorithmId(algorithmId)
                .monthCount(monthCount)
                .totalCount(totalCount)
                .users(usres)
                .build();
    }
}
