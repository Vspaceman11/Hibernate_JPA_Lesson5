package com.vlad.study.task1;


import com.vlad.study.task1.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by Asus on 01.11.2017.
 */
public class AuthorHelper {

    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Author> getAuthorList(){
        // открыть сессию - для манипуляции с персист. объектами
        Session session = sessionFactory.openSession();


        // этап подготовки запроса

        // объект-конструктор запросов для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated

        CriteriaQuery cq = cb.createQuery(Author.class);

        Root<Author> root = cq.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)


        cq.select(root);// необязательный оператор, если просто нужно получить все значения


         //этап выполнения запроса
        Query query = session.createQuery(cq);

        List<Author> authorList = query.getResultList();

        session.close();

        return authorList;
    }

    public Author getAuthorById(long id) {
        Session session = sessionFactory.openSession();
        Author author = session.get(Author.class, id); // получение объекта по id
        session.close();
        return author;
    }

    public void addAuthor(Author author){

        Session session = sessionFactory.openSession();
        session.beginTransaction();


        session.persist(author);

        session.getTransaction().commit();
        session.close();


    }
    public void updateAuthor(String newAuthorName, String newAuthorLast, int id){
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();

            Author authorToUpdate = session.get(Author.class, id);
            authorToUpdate.setName(newAuthorName);
            authorToUpdate.setLastName(newAuthorLast);

            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void addAuthorTwoHundredTimes(String authorName, String authorLastName){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (int i = 0, j = 0; i <= 200; i++, j++) {
            Author author = new Author("John Ronald Reuel", "Tolkien");
            if ((j % 10) == 0){
                session.flush();
            }
            session.persist(author);
        }


        session.getTransaction().commit();

        session.close();


    }
}
