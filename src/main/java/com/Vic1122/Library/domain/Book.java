package com.Vic1122.Library.domain;

//import javax.persistence.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Set;

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

    //@DateTimeFormat(pattern = "yyyy")
    @Min(value = 1, message = "Niedpowiedni rok wydania")
    @Max(value = 9999, message = "Niedpowiedni rok wydania")
    @NotNull(message = "Dana wymagana")
    private Integer yearOfPublishing;

    //@Column(name = "publisher")
    @NotEmpty(message = "Dana wymagana")
    private String publisher;

    //@Column(name = "isbn")
    @NotEmpty(message = "Dana wymagana")
    @Size(min=13, max=13, message = "Niepoprawny numer ISBN")
    private String isbn;

    @OneToOne
    //@NotEmpty(message = "Dana wymagana")
    private @Valid Author author;

    @OneToMany(mappedBy = "hiredBook", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Hire> hire;

    public Book(){

    }

    public Book(String title, Integer yearOfPublishing, String publisher, String isbn, Author author){
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
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

//    public Integer getYearOfPublishging() {
//        return yearOfPublishing;
//    }

    public void setYearOfPublishing(Integer yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
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

    public Integer getYearOfPublishing() {
        return yearOfPublishing;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor( Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
