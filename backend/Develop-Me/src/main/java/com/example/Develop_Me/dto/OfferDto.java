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
    private Users users;
    private Category category;
    private Hashtag hashtag;

    @Builder
    public OfferDto(Long offerId, String title, LocalDate postDate, String postText, Category category, Hashtag hashtag, Users users){
        this.offerId = offerId;
        this.users = users;
        this.title = title;
        this.postDate = postDate;
        this.postText = postText;
        this.category = category;
        this.hashtag = hashtag;
    }

    public Offer toEntity() {
        return Offer.builder()
                .offerId(offerId)
                .users(users)
                .title(title)
                .postDate(postDate)
                .category(category)
                .hashTag(hashtag)
                .postText(postText)
                .build();
    }
}
