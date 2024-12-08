package com.example.Develop_Me.Repository;

import com.example.Develop_Me.entity.Comments;
import com.example.Develop_Me.entity.Offer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    List<Comments> findByOffer(Offer offer);
}
