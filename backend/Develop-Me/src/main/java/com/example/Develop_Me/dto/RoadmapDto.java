package com.example.Develop_Me.dto;

import com.example.Develop_Me.entity.Category;
import com.example.Develop_Me.entity.Roadmap;
import com.example.Develop_Me.entity.Users;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
@NoArgsConstructor
public class RoadmapDto {

    private Long roadmapId;
    private int roadMapGroup;
    private String roadMapTitle;
    private String roadMapText;
    private Users users;
    private Category category;

    @Builder
    public RoadmapDto(Long roadmapId, int roadMapGroup, String roadMapTitle, String roadMapText, Users users, Category category){
        this.roadmapId = roadmapId;
        this.roadMapGroup = roadMapGroup;
        this.roadMapTitle = roadMapTitle;
        this.roadMapText = roadMapText;
        this.users = users;
        this.category = category;
    }

    public Roadmap toEntity(){
        return Roadmap.builder()
                .roadmapId(roadmapId)
                .roadMapGroup(roadMapGroup)
                .roadMapTitle(roadMapTitle)
                .roadMapText(roadMapText)
                .users(users)
                .category(category)
                .build();
    }
}
