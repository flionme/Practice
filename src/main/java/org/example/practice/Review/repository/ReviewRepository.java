package org.example.practice.Review.repository;

import org.example.practice.Review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer>
{
    List<Review> findByReviewContents(String reviewContents);
    
}
