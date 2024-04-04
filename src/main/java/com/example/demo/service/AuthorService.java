package com.example.demo.service;

import com.example.demo.model.Author;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

    @PersistenceContext
    private EntityManager entityManager;

    public void test(){
        EntityGraph<Author> entityGraph = entityManager.createEntityGraph(Author.class);
        entityGraph.addAttributeNodes("books");

        TypedQuery<Author> query = entityManager.createQuery("SELECT * FROM Author ", Author.class);
        query.setHint("javax.persistence.loadgrapg", entityGraph);
        query.getResultList();
    }
}
