package com.jwt.task.book.controller;

import com.jwt.task.book.BookRepository;
import com.jwt.task.book.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableCaching
@RequestMapping("/api/v2")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/book")
    public BookEntity save (@RequestBody BookEntity book)
    {
        return bookRepository.save(book);
    }

    @GetMapping("/books")
    public List<BookEntity> getAllBooks()
    {
        return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    @Cacheable(key = "#id", value = "Book")
    public BookEntity findBook(@PathVariable int id) {
        return bookRepository.findBookById(id);
    }

    @PutMapping("/book/{id}")
    public BookEntity update(@PathVariable int id, @RequestBody BookEntity book){
        return bookRepository.update(id,book);
    }

    @DeleteMapping("/book/{id}")
    @CacheEvict(key = "#id",value = "Book")
    public String remove(@PathVariable int id) {
        return bookRepository.deleteBook(id);
    }
}
