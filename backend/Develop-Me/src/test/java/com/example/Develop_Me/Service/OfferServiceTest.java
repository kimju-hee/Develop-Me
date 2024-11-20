package com.example.Develop_Me.Service;

import com.example.Develop_Me.Repository.OfferRepository;
import com.example.Develop_Me.Repository.UserRepository;
import com.example.Develop_Me.dto.OfferDto;
import com.example.Develop_Me.entity.Category;
import com.example.Develop_Me.entity.Offer;
import com.example.Develop_Me.entity.Users;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OfferServiceTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;
    @Autowired OfferRepository offerRepository;
    @Autowired OfferService offerService;

    @Test
    @DisplayName("게시글 등록")
    void posting() {

        //given
        Long userId = createMember();
        OfferDto offerDto = new OfferDto(1L, "제목", LocalDate.of(2024,11,20), "내용", true, 1L, 1L, 1L);

        //when
        Long offerId = offerService.savePost(userId, offerDto);

        //then

        Offer offer = offerRepository.findByOfferId(offerId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));

        OfferDto foundOfferDto = new OfferDto(
                offer.getOfferId(),
                offer.getTitle(),
                offer.getPostDate(),
                offer.getPostText(),
                offer.isPostStatus(),
                offer.getCategory() != null ? offer.getCategory().getCateId() : null,
                offer.getHashTag() != null ? offer.getHashTag().getHashtagId() : null,
                offer.getUsers() != null ? offer.getUsers().getUserId() : null
        );

        Assertions.assertEquals(foundOfferDto.getOfferId(), offerId);
        Assertions.assertEquals(foundOfferDto.getTitle(), "제목");
        Assertions.assertEquals(foundOfferDto.getPostDate(), LocalDate.of(2024, 11, 20));
        Assertions.assertEquals(foundOfferDto.getPostText(), "내용");
        Assertions.assertTrue(foundOfferDto.isPostStatus());

        }

    @Test
    @DisplayName("게시글 수정")
    public void updatePost() {
        //given
        Long userId = createMember();
        OfferDto offerDto = new OfferDto(1L, "제목", LocalDate.of(2024, 11, 20), "내용", true, 1L, 1L, 1L);
        Long offerId = offerService.savePost(userId, offerDto);
        OfferDto modifiedOfferFormDto = new OfferDto(1L, "제목2", LocalDate.of(2024, 11, 20), "내용2", true, 1L, 1L, 1L);

        //when
        Long updateOfferId = offerService.updatePost(offerId, modifiedOfferFormDto);

        //then
        OfferDto foundOfferDto = offerService.findByOfferId(offerId);
        Assertions.assertEquals("제목", offerDto.getTitle());
        Assertions.assertEquals("내용", offerDto.getPostText());
    }

    @Test
    @DisplayName("게시글 삭제")
    public void deletePost() {
        //when
        Long userId = createMember();
        OfferDto offerDto = new OfferDto(1L, "제목", LocalDate.of(2024, 11, 20), "내용", true, 1L, 1L, 1L);
        Long offerId = offerService.savePost(userId, offerDto);

        //when
        offerService.deletePost(offerId);

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            offerService.findByOfferId(offerId);
        });
    }

        private Long createMember() {
        Users users = Users.builder()
                .userId(1L)
                .nickname("nickname")
                .tech("tech")
                .email("test@example.com")
                .password("password123")
                .category(new Category(1L))
                .build();
        return userRepository.save(users).getUserId();
    }
}

