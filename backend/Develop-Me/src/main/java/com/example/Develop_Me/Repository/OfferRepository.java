package com.example.Develop_Me.Repository;

import com.example.Develop_Me.entity.Offer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    Optional<Offer> findByOfferId(Long offerId);
}
