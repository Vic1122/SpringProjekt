package com.Vic1122.Library.domain;

import org.springframework.stereotype.Component;

@Component
public class Book {
    private String title;
    private int yearOfPublisging;
    private String publisher;
    private String isbn;

    public Book(){
        this.title = "AAA";
        this.yearOfPublisging = 1234;
        this.publisher = "Alto";
        this.isbn = "QWS23443";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublisging() {
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

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", yearOfPublisging=" + yearOfPublisging +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
