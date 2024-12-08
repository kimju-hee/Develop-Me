package com.example.Develop_Me.Service;

import com.example.Develop_Me.Repository.CommentsRepository;
import com.example.Develop_Me.Repository.OfferRepository;
import com.example.Develop_Me.Repository.UserRepository;
import com.example.Develop_Me.dto.CommentDto;
import com.example.Develop_Me.entity.Comments;
import com.example.Develop_Me.entity.Offer;
import com.example.Develop_Me.entity.Users;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;
    private final UserRepository userRepository;
    private final OfferRepository offerRepository;

    @Transactional
    public Long saveComment(Long userId, Long offerId, CommentDto commentsDto) {
        Users user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));

        Comments comment = Comments.builder()
                .comment(commentsDto.getComment())
                .users(user)
                .offer(offer)
                .build();

        commentsRepository.save(comment);
        return comment.getCommentId();
    }

    public List<CommentDto> findCommentsByOfferId(Long offerId) {
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));

        return commentsRepository.findByOffer(offer).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteComment(Long commentId) {
        commentsRepository.deleteById(commentId);
    }

    private CommentDto convertToDto(Comments comment) {
        return CommentDto.builder()
                .commentId(comment.getCommentId())
                .comment(comment.getComment())
                .userId(comment.getUsers().getUserId())
                .offerId(comment.getOffer().getOfferId())
                .build();
    }
}
