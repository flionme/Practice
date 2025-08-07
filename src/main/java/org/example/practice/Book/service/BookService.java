package org.example.practice.Book.service;

import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.example.practice.Book.model.Book;
import org.example.practice.Book.model.BookDto;
import org.example.practice.Book.repository.BookRepository;
import org.example.practice.Review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public void bookRegister(BookDto.BookRegister dto) {
        Book book = bookRepository.save(dto.toEntity());
    }

    public List<BookDto.BookRes> list() {
        List<Book> result = bookRepository.findAll();

        return result.stream().map(BookDto.BookRes::from).toList();
    }

    public BookDto.BookRes read(Integer id) {
        Optional<Book> result = bookRepository.findById(id);

        if (result.isPresent()) {
            Book entity = result.get();

            return BookDto.BookRes.from(entity);
        }

        return null;
    }

    public List<BookDto.BookRes> search(String title) {
        List<Book> result = bookRepository.findByTitle(title);

        return result.stream().map(BookDto.BookRes::from).toList();
    }

}
