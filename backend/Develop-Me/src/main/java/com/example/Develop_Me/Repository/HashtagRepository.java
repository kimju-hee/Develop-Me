package com.example.Develop_Me.Repository;

import com.example.Develop_Me.entity.Hashtag;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
    Optional<Hashtag> findByHashtagId(Long hashtagId);
}
