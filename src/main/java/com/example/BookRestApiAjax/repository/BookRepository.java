package com.example.BookRestApiAjax.repository;

import com.example.BookRestApiAjax.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
