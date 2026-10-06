package com.chloe.demo;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private BookResponse toResponse(Book book) {
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        response.setPrice(book.getPrice());
        response.setCategory(book.getCategory());
        return response;
    }

    public List<BookResponse> findAll() {
        List<Book> books = bookRepository.findAll();
        List<BookResponse> responses = new ArrayList<>();
        for (Book book : books) {
            responses.add(toResponse(book));
        }

        return responses;
    }

    public BookResponse findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        return toResponse(book);
    }

    public BookResponse save(BookRequest bookRequest) {
        Book book = new Book();
        book.setAuthor(bookRequest.getAuthor());
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        book.setCreatedAt(LocalDateTime.now());
        book.setUpdatedAt(LocalDateTime.now());
        book.setCategory(bookRequest.getCategory());

        Book savedBook = bookRepository.save(book);

        return toResponse(savedBook);
    }

    public BookResponse update(Long id, BookRequest bookRequest) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            return null;
        }
        book.setUpdatedAt(LocalDateTime.now());
        book.setPrice(bookRequest.getPrice());
        book.setTitle(bookRequest.getTitle());
        book.setTitle(bookRequest.getTitle());
        book.setCategory(bookRequest.getCategory());

        Book savedBook = bookRepository.save(book);

        return toResponse(savedBook);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
