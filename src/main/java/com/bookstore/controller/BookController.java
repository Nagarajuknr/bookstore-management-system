package com.bookstore.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.bookstore.model.Book;
import com.bookstore.service.BookService;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {
    
    private final BookService service;
    
    public BookController(BookService service) {
        this.service = service;
    }
    
    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return service.saveBook(book);
    }
    
    @GetMapping
    public List<Book> getBooks() {
        return service.getAllBooks();
    }
    
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return service.getBookById(id);
    }
    
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return service.updateBook(id, book);
    }
    
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return "Book deleted successfully";
    }
}