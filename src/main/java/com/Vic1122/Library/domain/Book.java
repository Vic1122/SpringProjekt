package com.Vic1122.Library.domain;

//import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "book_id")
    private int id;
    //@Column(name = "book_title")
    private String title;
    //@Column(name = "year_of_publishing")
    private int yearOfPublisging;
    //@Column(name = "publisher")
    private String publisher;
    //@Column(name = "isbn")
    private String isbn;

    private String author;

    public Book(){

    }

    public Book(String title, int yearOfPublisging, String publisher,String isbn, String author){
        this.title = title;
        this.yearOfPublisging = yearOfPublisging;
        this.publisher = publisher;
        this.isbn = isbn;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublishging() {
        return yearOfPublisging;
    }

    public void setYearOfPublisging(int yearOfPublisging) {
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

    public int getYearOfPublisging() {
        return yearOfPublisging;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearOfPublisging=" + yearOfPublisging +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
