package com.cg.main;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private static EntityManager em;
    static {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        em = emf.createEntityManager();
    }

 public void addAuthor(Author author, List<Book> books)
    {
        em.getTransaction().begin();

        for(Book b : books){
            b.setAuthor(author);
        }
        em.persist(author);
        em.getTransaction().commit();
        System.out.println("Author with multiple books added.");

    }

    public List<Author>getAuthors() {
        Query q1 = em.createQuery("from Author");
        List<Author> li = q1.getResultList();

        for (Author a : li) {
            System.out.println("Author: " + a.getAuthorName());
             for(Book b : a.getBooks()){
                 System.out.println("Book : " +b.getTitle());
             }
        }
        return li;
    }

    public void updatePrice(int bid,double price1)
    {
        em.getTransaction().begin();
        Book b = em.find(Book.class,bid);
        if(b!=null){
            b.setPrice(price1);
            System.out.println("Price updated.");
        }
        System.out.println("no book available");
        em.getTransaction().commit();
    }

    public void deleteBook(int bid){
        em.getTransaction().begin();
        Book b = em.find(Book.class,bid);
        if(b!=null){
            em.remove(b);
            System.out.println(" books are deleted.");
        }

        em.getTransaction().commit();

    }
    public void deleteAuthor(int aid){
        em.getTransaction().begin();
        Author a = em.find(Author.class,aid);

        if(a!=null){
            em.remove(a);
            System.out.println("author and their books are deleted");
        }
        em.getTransaction().commit();
    }
}
