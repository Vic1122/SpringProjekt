package com.Vic1122.Library;


import com.Vic1122.Library.domain.Author;
import com.Vic1122.Library.domain.Book;
import com.Vic1122.Library.services.BookService;
import com.Vic1122.Library.services.HireService;
import com.Vic1122.Library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStarter implements CommandLineRunner {


    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    @Autowired
    HireService hireService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(hireService.getHiresByBookId(2).size());
    }

    public void init() {
        Book book = new Book("poopapp", 1212, "uuiis", "2121ww21ee123", new Author("Mirek spod monopolowego"));
        Book book2 = new Book("p222oopapp", 1234, "uuiis", "2121ww21ee123", new Author("Mirek spod monopolowego"));
        bookService.saveBook(book);
        bookService.saveBook(book2);
    }

    public void initUsers() {
        userService.createUser("admin", "pass");

        userService.addRoleToUser("admin", "ADMIN");
        userService.addRoleToUser("admin", "USER");
        userService.addRoleToUser("admin", "DEV");

        userService.createUser("user", "pass");
        userService.addRoleToUser("user", "USER");
    }

}
