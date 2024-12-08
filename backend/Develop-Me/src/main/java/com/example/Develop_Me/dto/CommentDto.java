package com.example.Develop_Me.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDto {
    private Long commentId;
    private String comment;
    private Long userId;
    private Long offerId;

    @Builder
    public CommentDto(Long commentId, String comment, Long userId, Long offerId) {
        this.commentId = commentId;
        this.comment = comment;
        this.userId = userId;
        this.offerId = offerId;
    }
}
