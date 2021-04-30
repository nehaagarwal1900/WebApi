package com.webapi.webapi.controller;


import com.sun.el.stream.Optional;
import com.webapi.webapi.model.Book;
import com.webapi.webapi.repo.BookRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.support.ResourceHolderSupport;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @PostMapping("/booksave")
    public String insertBook(@RequestBody Book book){
        bookRepository.save(book);
        return "your record is saved successfully!!";
    }

    @PostMapping("/multipleBookSave")

    public String insertBook(@RequestBody List<Book> book) {
        bookRepository.saveAll(book);
        return "record is saved successfully!!!";
    }

       @DeleteMapping("/deleteBook/{id}")

    public String deleteBook(@PathVariable(value="id") long bookId){
        bookRepository.findById(bookId);
        bookRepository.deleteById(bookId);
        return  "record is sucessfully deleted";


       }


    @PostMapping("/updateBook")

    public String updateBook(@RequestParam("bookId") long bookId, @RequestBody Book book){

        Book book1 = bookRepository.findById(bookId).get();
        book1.setBookName(book.getBookName());
        book1.setBookAuthor(book.getBookAuthor());
        bookRepository.save(book1);
        return "record is saved successfully!!";




    }

    @GetMapping("/getAllBook")
    public List<Book>getBook(){
        return (List<Book>)bookRepository.findAll();
    }

}
