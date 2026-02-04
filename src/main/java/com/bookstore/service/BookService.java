package com.bookstore.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;

@Service
public class BookService {
    
    private final BookRepository repository;
    
    public BookService(BookRepository repository) {
        this.repository = repository;
    }
    
    public Book saveBook(Book book) {
        return repository.save(book);
    }
    
    public List<Book> getAllBooks() {
        return repository.findAll();
    }
    
    public Book getBookById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
    }
    
    public Book updateBook(Long id, Book book) {
        Book existing = getBookById(id);
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setPrice(book.getPrice());
        existing.setQuantity(book.getQuantity());
        return repository.save(existing);
    }
    
    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}