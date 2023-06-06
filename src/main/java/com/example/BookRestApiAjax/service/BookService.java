package com.example.BookRestApiAjax.service;

import com.example.BookRestApiAjax.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List <Book> listAllBook();
    Book getBookById(int id);
    Book insertBook(Book book);
    Book updateBook(Book book,int id);
    int deleteBook(int id);
}
