package org.example.practice.Book.repository;

import org.example.practice.Book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitle(String title);
}
