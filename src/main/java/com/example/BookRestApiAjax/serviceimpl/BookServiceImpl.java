package com.example.BookRestApiAjax.serviceimpl;

import com.example.BookRestApiAjax.entity.Book;
import com.example.BookRestApiAjax.exception.ResourceNOtFoundException;
import com.example.BookRestApiAjax.repository.BookRepository;
import com.example.BookRestApiAjax.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

@Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> listAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        Optional<Book> book= bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        }else {
            throw new ResourceNOtFoundException("Book","Id",id);
        }
     // instead of above this is lemda expression
        // return bookRepository.findById(id).orElseThrow(() -> new ResourceNOtFoundException("Book","Id",id));
    }



    @Override
    public Book insertBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book,int id) {

        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new ResourceNOtFoundException("Book","Id",id));
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());
        bookRepository.save(existingBook);
        return existingBook;
    }

    @Override
    public int deleteBook(int id) {
        bookRepository.findById(id).orElseThrow(() -> new ResourceNOtFoundException("Book","Id",id));
        bookRepository.deleteById(id);
        return id;
    }


}
