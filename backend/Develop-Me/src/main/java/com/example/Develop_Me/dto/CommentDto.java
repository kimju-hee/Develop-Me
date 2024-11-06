package com.example.Develop_Me.dto;

import com.example.Develop_Me.entity.Category;
import com.example.Develop_Me.entity.Comments;
import com.example.Develop_Me.entity.Offer;
import com.example.Develop_Me.entity.Users;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDto {
    private Long commentId;
    private String comment;
    private Users users;
    private Offer offer;
    private Category category;

    @Builder
    public CommentDto(Long commentId, String comment, Users users, Offer offer, Category category) {
        this.commentId = commentId;
        this.comment = comment;
        this.users = users;
        this.offer = offer;
        this.category = category;
    }

    public Comments toEntity() {
        return Comments.builder()
                .commentId(commentId)
                .comment(comment)
                .users(users)
                .offer(offer)
                .category(category)
                .build();
    }
}

