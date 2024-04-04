package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @CachePut(value = "bookCache", key = "#name")
    public Book getBook(Long id){
        return bookRepository.findById(id).get();
    }

    @CacheEvict(value = "bookCache")
    public void remove(Long id){

    }
}
