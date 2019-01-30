package com.Vic1122.Library;


import com.Vic1122.Library.domain.Book;
import com.Vic1122.Library.repository.BookRepository;
import com.Vic1122.Library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class AppStarter implements CommandLineRunner{


    @Autowired
    BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        init();
    }

    public void init(){
        Book book = new Book("poopapp", 1234,"uuiis", "55ss663ew", "Mirek spod monopolowego");
        Book book2 = new Book("p222oopapp", 1234,"uuiis", "55ss663ew", "Mirek spod monopolowego");
        bookService.saveBook(book);
        bookService.saveBook(book2);
    }


}
