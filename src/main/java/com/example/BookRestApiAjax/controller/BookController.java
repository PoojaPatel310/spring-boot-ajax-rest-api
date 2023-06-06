package com.example.BookRestApiAjax.controller;

import com.example.BookRestApiAjax.entity.Book;
import com.example.BookRestApiAjax.entity.ServiceResponse;
import com.example.BookRestApiAjax.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {

    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    List<Book> bookstore = new ArrayList<>();
    @PostMapping("/saveBook")
    public ResponseEntity<Object> addBook(@RequestBody Book book){
        bookstore.add(book);
System.out.println(book);
        ServiceResponse<Book> response =new ServiceResponse<Book>("success",book);
        return  new ResponseEntity<Object>(response,HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<Book> saveBook( @RequestBody Book book){
//    return new ResponseEntity<Book>(bookService.insertBook(book), HttpStatus.CREATED);
//    }
    @GetMapping("/list")
    public List<Book> getAllBook(){
    return bookService.listAllBook();
    }
    @GetMapping("{id}")
     public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
    return new ResponseEntity<Book>(bookService.getBookById(id),HttpStatus.OK);
     }
     @PutMapping("{id}")
     public ResponseEntity<Book> updateBook(@PathVariable("id") int id
                                            ,@RequestBody Book book){
    return new ResponseEntity<Book>(bookService.updateBook(book,id),HttpStatus.OK);

     }
     @DeleteMapping("{id}")
     public ResponseEntity<String> deleteBook(@PathVariable("id") int id){
       bookService.deleteBook(id);
       return new ResponseEntity<String>("Book deleted successfully!",HttpStatus.OK);
     }

}
