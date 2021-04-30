package com.webapi.webapi.model;

import com.webapi.webapi.repo.BookRepository;

import javax.persistence.*;

@Entity
@Table(name="tbl_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;
    private String bookName;
    private String bookAuthor;

    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }


    @Override
    public String toString() {
        return "Book{" +
                "bookAuthor=" + bookAuthor +
                '}';
    }


}
