package org.example.practice.Review.service;

import lombok.RequiredArgsConstructor;
import org.example.practice.Book.model.Book;
import org.example.practice.Book.repository.BookRepository;
import org.example.practice.Review.model.Review;
import org.example.practice.Review.model.ReviewDto;
import org.example.practice.Review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService
{
    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;
    
    public void register(ReviewDto.Register dto)
    {
        Optional<Book> book = bookRepository.findById(dto.getBookIdx());
        Book bookReslt = book.get();
        
        
        reviewRepository.save(dto.toEntity(bookReslt));
    }
    
    public List<ReviewDto.reviewRes> list()
    {
        List<Review> result = reviewRepository.findAll();
        
        return result.stream().map(ReviewDto.reviewRes::from).toList();
    }
    
    
    public ReviewDto.reviewRes read(Integer idx)
    {
        Optional<Review> result = reviewRepository.findById(idx);
        
        if(!result.isEmpty())
        {
            Review entity = result.get();
            return ReviewDto.reviewRes.from(entity);
        }
            return null;
    }
    
    
    public List<ReviewDto.reviewRes> search(String content)
    {
        List<Review> result = reviewRepository.findByReviewContents(content);
        return result.stream().map(ReviewDto.reviewRes::from).toList();
    }
}
