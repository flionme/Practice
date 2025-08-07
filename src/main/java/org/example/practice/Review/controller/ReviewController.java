package org.example.practice.Review.controller;

import lombok.RequiredArgsConstructor;
import org.example.practice.Review.model.Review;
import org.example.practice.Review.model.ReviewDto;
import org.example.practice.Review.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController
{
    private final ReviewService reviewService;
    
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody ReviewDto.Register dto,String title)
    {
        reviewService.register(dto,title);
        
        return ResponseEntity.status(200).body("Success");
    }
    
    @GetMapping("/list")
    public ResponseEntity list()
    {
        List<ReviewDto.reviewRes> result =  reviewService.list();
        
        return ResponseEntity.status(200).body(result);
    }
    
    @GetMapping("/read")
    public ResponseEntity read(Integer idx)
    {
        ReviewDto.reviewRes result = reviewService.read(idx);
        
        
        return ResponseEntity.status(200).body(result);
    }
    
    @GetMapping("/search")
    public ResponseEntity search(String content)
    {
        List<ReviewDto.reviewRes> result =  reviewService.search(content);
        
        
        return ResponseEntity.status(200).body(result);
    }
    
}
