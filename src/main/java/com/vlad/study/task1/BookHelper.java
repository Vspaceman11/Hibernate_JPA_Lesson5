package com.vlad.study.task1;

import com.vlad.study.task1.entity.Book;
import com.vlad.study.task1.entity.Author;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookHelper {
    private SessionFactory sessionFactory;

    public BookHelper(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Book> getBookList(){
        Session session = sessionFactory.openSession();
        List<Book> bookList = session.createQuery("From Book").getResultList();
        session.close();
        return bookList;
    }
    public Book getBookById(long id){
        Session session = sessionFactory.openSession();
        Book book = session.get(Book.class, id);
        session.close();
        return book;
    }
    public void addBook(Book book){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(book);
        session.getTransaction().commit();
        session.close();
    }

    public void updateBookById(String bookName, int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Book book = session.get(Book.class, id);
        book.setName(bookName);
        session.getTransaction().commit();
        session.close();
    }
    public List<Book> getBookNameAndAuthorName(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Book.class);
        Root<Author> root = cq.from(Book.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        List<Book> bookList = query.getResultList();
        //        Query query = session.createQuery("select b.name, a.name from Book as b " +
//                "join Author as a ON a.id = b.authorId");
//        List<Object> bookAndAuthor = query.list();
        session.close();
        return bookList;
    }
}
