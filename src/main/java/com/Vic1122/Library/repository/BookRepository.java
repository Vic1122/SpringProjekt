package com.Vic1122.Library.repository;

import com.Vic1122.Library.domain.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager em;

    public Collection<Book> getBooks() {
        return em.createQuery("from Book", Book.class).getResultList();
    }

    public Book getBook(int id) {
        return em.find(Book.class, id);
    }

    @Transactional//jak robi się transakcję CUD
    public void saveBook(Book book) {
        if (book != null)
            em.persist(book);
    }

    @Transactional
    public void removeBook(Book book) {
        if (book != null)
            em.remove(book);
    }

    @Transactional
    public void updateBook(Book book) {
        if (book != null)
            em.merge(book);
    }


    public Collection<Book> getBooksByAuthor(String authorName) {
        return em.createQuery("from Book b WHERE LOWER(b.author.name) LIKE CONCAT('%',:authorName,'%')", Book.class)
                .setParameter("authorName", authorName.toLowerCase())
                .getResultList();
    }

    public Collection<Book> getBooks(Integer yearOfPublisging, String isbn, String publisher) {

        String query = "from Book b";
        String condition = "";

        if (yearOfPublisging == null)
            condition += "b.yearOfPublisging = :yearOfPublisging";

        if (publisher == null)
            if (condition.isEmpty())
                condition += "b.publisher =:publisher";
            else
                condition += " AND b.publisher =:publisher";

        if (isbn == null)
            if (condition.isEmpty())
                condition += "b.isbn =:isbn";
            else
                condition += " AND b.isbn =:isbn";

        if (!condition.isEmpty())
            query += " WHERE " + condition;
        System.out.println(query);

        TypedQuery typedQuery = em.createQuery(query, Book.class);
        if (yearOfPublisging != null)
            typedQuery.setParameter("yearOfPublisging", yearOfPublisging);

        if (isbn != null)
            typedQuery.setParameter("isbn", isbn);

        if (publisher != null)
            typedQuery.setParameter("publisher", publisher);

        return typedQuery.getResultList();

//        return em.createQuery(query, Book.class)
//                .setParameter("yearOfPublisging", yearOfPublisging)
//                .setParameter("isbn", isbn)
//                .setParameter("publisher", publisher)
//                .getResultList();
    }

}
