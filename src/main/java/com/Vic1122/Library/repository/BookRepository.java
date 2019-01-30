package com.Vic1122.Library.repository;

import com.Vic1122.Library.domain.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager em;

    public Collection<Book> getBooks(){
        return  em.createQuery("from Book", Book.class).getResultList();
    }

    public Book getBook(int id){
        return em.find(Book.class, id);
    }

    @Transactional//jak robi się transakcję CUD
    public void saveBook(Book book){
        if(book!=null)
            em.persist(book);
    }

    @Transactional
    public void removeBook(Book book){
        if(book != null)
            em.remove(book);
    }

    @Transactional
    public void updateBook(Book book){
        if(book != null)
            em.merge(book);
    }

}
