package com.example.RestAPIQuestion.Question6;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> search(String title, String author) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be blank");
        }

        List<Book> books = bookRepository.findByTitleAndAuthor(title.trim(), author);
        if (books.isEmpty()) {
            throw new BookNotFoundException("No books found");
        }
        return books;
    }
}