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
    public List<Book> findAll() {
       return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
