package org.example.practice.Review.model;

import lombok.Builder;
import lombok.Getter;
import org.example.practice.Book.model.Book;

public class ReviewDto
{
    @Getter
    public static class Register
    {
        private Integer bookIdx;
        private String reviewContents;
        private Integer score;
        
        public Review toEntity(Book book)
        {
            Review entity = Review.builder()
                    .reviewContents(reviewContents)
                    .score(score)
                    .book(book)
                    .build();
            return entity;
        }
    }
    
    @Builder
    @Getter
    public static class reviewRes
    {
        private Integer idx;
        private String reviewContents;
        private Integer score;
        
        public static ReviewDto.reviewRes from(Review entity)
        {
            ReviewDto.reviewRes dto = reviewRes.builder()
                    .idx(entity.getIdx())
                    .reviewContents(entity.getReviewContents())
                    .score(entity.getScore())
                    .build();
            return dto;
        }
    
    }
}
