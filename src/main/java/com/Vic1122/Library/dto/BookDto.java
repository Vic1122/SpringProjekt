package com.Vic1122.Library.dto;

import com.Vic1122.Library.domain.Author;

import javax.validation.Valid;
import java.text.SimpleDateFormat;

public class BookDto {

    private String title;
    private Integer yearOfPublisging;
    private String publisher;
    private String isbn;
    private Author author;

    public BookDto(String title, Integer yearOfPublisging, String publisher, String isbn, Author author) {
        this.title = title;
        this.yearOfPublisging = yearOfPublisging;
        this.publisher = publisher;
        this.isbn = isbn;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYearOfPublisging() {
        return yearOfPublisging;
    }

    public void setYearOfPublisging(Integer yearOfPublisging) {
        this.yearOfPublisging = yearOfPublisging;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
