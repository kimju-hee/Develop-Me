package com.example.Develop_Me.Service;

import com.example.Develop_Me.Repository.CategoryRepository;
import com.example.Develop_Me.Repository.HashtagRepository;
import com.example.Develop_Me.Repository.OfferRepository;
import com.example.Develop_Me.Repository.UserRepository;
import com.example.Develop_Me.dto.OfferDto;
import com.example.Develop_Me.entity.Category;
import com.example.Develop_Me.entity.Hashtag;
import com.example.Develop_Me.entity.Offer;
import com.example.Develop_Me.entity.Users;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Setter
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final HashtagRepository hashtagRepository;

    // 등록
    @Transactional
    public Long savePost(Long userId, OfferDto offerDto){

        Users users = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));

        Category category = categoryRepository.findById(offerDto.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("카테고리를 찾을 수 없습니다."));

        Hashtag hashtag = hashtagRepository.findById(offerDto.getHashtagId())
                .orElseThrow(() -> new IllegalArgumentException("해시태그를 찾을 수 없습니다."));


        Offer offer = Offer.builder()
                .title(offerDto.getTitle())
                .postDate(offerDto.getPostDate())
                .postText(offerDto.getPostText())
                .postStatus(offerDto.isPostStatus())
                .category(category)
                .hashTag(hashtag)
                .users(users)
                .build();
        offerRepository.save(offer);

        return offer.getOfferId();
    }

    // 수정
    @Transactional
    public Long updatePost(Long offerId, OfferDto offerDto){
        Offer offer = offerRepository.findByOfferId(offerId).orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다"));

        offer.update(offerDto.getTitle(), offerDto.getPostText());

        return offerId;
    }

    // 삭제
    @Transactional
    public void deletePost(Long offerId){
        offerRepository.deleteById(offerId);
    }

    // 조회
    public OfferDto findByOfferId(Long offerId) {
        Offer offer = offerRepository.findByOfferId(offerId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));

        return OfferDto.builder()
                .offerId(offer.getOfferId())
                .title(offer.getTitle())
                .postDate(offer.getPostDate())
                .postText(offer.getPostText())
                .postStatus(offer.isPostStatus())
                .userId(offer.getUsers().getUserId())
                .categoryId(offer.getCategory().getCateId())
                .hashtagId(offer.getHashTag().getHashtagId())
                .build();
    }
}
