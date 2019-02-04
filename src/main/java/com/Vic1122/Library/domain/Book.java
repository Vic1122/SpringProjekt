package com.Vic1122.Library.domain;

//import javax.persistence.*;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "book_id")
    private int id;
    //@Column(name = "book_title")
    @Size(min=2, message = "Tytuł musi mieć conajmniej dwie litery")
    @NotNull(message = "Dana wymagana")
    private String title;
    //@Column(name = "year_of_publishing")
    @NotNull(message = "Dana wymagana")
    @Range(min=1, max=9999, message = "Niedpowiedni rok wydania")
    private int yearOfPublisging;
    //@Column(name = "publisher")
    private String publisher;
    //@Column(name = "isbn")
    private String isbn;

    @OneToOne
    private Author author;

    public Book(){

    }

    public Book(String title, int yearOfPublisging, String publisher,String isbn, Author author){
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
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
