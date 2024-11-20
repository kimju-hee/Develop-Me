package com.example.Develop_Me.dto;

import com.example.Develop_Me.entity.Category;
import com.example.Develop_Me.entity.Hashtag;
import com.example.Develop_Me.entity.Offer;
import com.example.Develop_Me.entity.Users;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OfferDto {
    private Long offerId;
    private String title;
    private LocalDate postDate;
    private String postText;
    private boolean postStatus;
    private Long userId;
    private Long categoryId;
    private Long hashtagId;

    @Builder
    public OfferDto(Long offerId, String title, LocalDate postDate, String postText, boolean postStatus, Long userId, Long categoryId, Long hashtagId) {
        this.offerId = offerId;
        this.title = title;
        this.postDate = postDate;
        this.postText = postText;
        this.postStatus = postStatus;
        this.userId = userId;
        this.categoryId = categoryId;
        this.hashtagId = hashtagId;
    }

    public Offer toEntity(Users users, Category category, Hashtag hashtag) {
        return Offer.builder()
                .offerId(offerId)
                .users(users)
                .title(title)
                .postDate(postDate)
                .category(category)
                .hashTag(hashtag)
                .postText(postText)
                .postStatus(postStatus)
                .build();
    }

    public void validateForUpdate() {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("제목은 비어 있을 수 없습니다.");
        }
        if (postText == null || postText.isBlank()) {
            throw new IllegalArgumentException("본문은 비어 있을 수 없습니다.");
        }
    }
}
