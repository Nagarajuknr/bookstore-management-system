package com.bookstore;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class BookstoreManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreManagementSystemApplication.class, args);
	}
		 @GetMapping("/")
		    public String welcome() {
		        return "Welcome to Bookstore Management System! Go to /api/books to see all books.";
		    }
	

}
