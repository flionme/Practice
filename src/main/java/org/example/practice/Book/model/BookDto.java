package org.example.practice.Book.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class BookDto {

    @Getter
    public static class BookRegister {
        private String title;
        private Integer page;
        private Integer price;

        public Book toEntity() {
            Book entity = Book.builder()
                    .title(title)
                    .page(page)
                    .price(price)
                    .build();

            return entity;
        }
    }

    @Getter
    @Builder
    public static class BookRes {
        private Integer id;
        private String title;
        private Integer page;
        private Integer price;

        public static BookRes from(Book entity) {
            BookRes dto = BookRes.builder()
                    .id(entity.getId())
                    .title(entity.getTitle())
                    .page(entity.getPage())
                    .price(entity.getPrice())
                    .build();

            return dto;
        }
    }
}
