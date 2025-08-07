package org.example.practice.Review.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.practice.Book.model.Book;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;
    private String reviewContents;
    private Integer score;
    
    @ManyToOne
    @JoinColumn(name = "book_idx")
    private Book book;
    
}
