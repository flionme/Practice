package org.example.practice.Book.controller;

import lombok.RequiredArgsConstructor;
import org.example.practice.Book.model.BookDto;
import org.example.practice.Book.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @PostMapping("/register")
    public ResponseEntity<String> bookRegister(@RequestBody BookDto.BookRegister dto) {
        bookService.bookRegister(dto);

        return ResponseEntity.status(200).body("등록 완료");
    }

    @GetMapping("/list")
    public ResponseEntity<List<BookDto.BookRes>> bookList() {
        List<BookDto.BookRes> response = bookService.list();

        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/read")
    public ResponseEntity<BookDto.BookRes> read(Integer id) {
        BookDto.BookRes response = BookService.read(id);

        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookDto.BookRes>> search(String title) {
        List<BookDto.BookRes> response = bookService.search(title);

        return ResponseEntity.status(200).body(response);
    }
}
