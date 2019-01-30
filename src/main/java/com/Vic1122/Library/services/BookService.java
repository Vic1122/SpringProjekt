package com.Vic1122.Library.services;

import com.Vic1122.Library.domain.Book;
import com.Vic1122.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks(){
        return new ArrayList<>(bookRepository.getBooks());
    }

    public void saveBook(Book book){
        bookRepository.saveBook(book);
    }

    public void removeBook(int id){
        bookRepository.removeBook(bookRepository.getBook(id));
    }

    public Book getNevBook(){
        return new Book();
    }
}
