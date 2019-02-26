package com.Vic1122.Library;


import com.Vic1122.Library.domain.Author;
import com.Vic1122.Library.domain.Book;
import com.Vic1122.Library.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppStarter implements CommandLineRunner {


    @Autowired
    BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        init();
    }

    public void init() {
        Book book = new Book("poopapp", 1212, "uuiis", "2121ww21ee123", new Author("Mirek spod monopolowego"));
        Book book2 = new Book("p222oopapp", 1234, "uuiis", "2121ww21ee123", new Author("Mirek spod monopolowego"));
        bookService.saveBook(book);
        bookService.saveBook(book2);
    }

}
