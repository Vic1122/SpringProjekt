package com.Vic1122.Library.services;

import com.Vic1122.Library.domain.Author;
import com.Vic1122.Library.domain.Book;
import com.Vic1122.Library.repository.AuthorRepository;
import com.Vic1122.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public List<Book> getBooks(){
        return new ArrayList<>(bookRepository.getBooks());
    }

    public void saveBook(Book book){
        if(book!=null) {
            System.out.println("Zapisuję książkę i id: " + book.getId());
            boolean bookExists = bookRepository.getBook(book.getId()) != null;

            if(bookExists) {
                authorRepository.updateAuthor(book.getAuthor());
                bookRepository.updateBook(book);
            }else {
                authorRepository.saveAuthor(book.getAuthor());
                bookRepository.saveBook(book);
            }
        }
    }

    public void removeBook(int id){
        Book bookRemove = bookRepository.getBook(id);
        Author authorToRemove = bookRemove.getAuthor();

        bookRepository.removeBook(bookRemove);
        authorRepository.removeAuthor(authorToRemove);
    }

    public Book getNevBook(){
        Book newBook = new Book();
        newBook.setAuthor(new Author());
        return newBook;
    }

    public Book getBook(int id){
        return bookRepository.getBook(id);
    }

    public List<Book> getBooksByAuthor(String authorName){
        if (authorName != null)
            return  new ArrayList<>(bookRepository.getBooksByAuthor(authorName));
        else
            return null;
    }

    public List<Book> getBooks (Integer yearOfPublisging, String isbn, String publisher){
        return  new ArrayList<>(bookRepository.getBooks(yearOfPublisging, isbn, publisher));
    }
}
