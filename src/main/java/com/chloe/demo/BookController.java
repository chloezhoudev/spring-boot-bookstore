package com.chloe.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookResponse> findAll() {
       return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookResponse findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public BookResponse save(@RequestBody BookRequest book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public BookResponse update(@PathVariable Long id, @RequestBody BookRequest book) {
        return bookService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
