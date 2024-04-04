package com.example.demo.repository;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a JOIN FETCH a.books WHERE a.id = :id")
    Author findByIdWIthBooks(@Param("id") Long id);

    @Query("SELECT a.books FROM Author  a WHERE a.id = :authorId")
    List<Book> findBooksByAuthorId(@Param("authorId") Long authorId);

    @EntityGraph(attributePaths = "books")
    Optional<Author> findById(Long id);
}
