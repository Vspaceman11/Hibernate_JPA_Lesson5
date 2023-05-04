package com.vlad.study.task1;

import com.vlad.study.task1.entity.Author;
import com.vlad.study.task1.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Asus on 01.11.2017.
 */
public class HibernateUtil {

    private static SessionFactory factory;
    private static final Logger LOG = LogManager.getLogger( HibernateUtil.class.getName() );

    static {
        try {
             factory = new Configuration()
                     .addAnnotatedClass(Author.class)
                     .addAnnotatedClass(Book.class)
                    .configure()
                    .buildSessionFactory();
        } catch (HibernateException e) {
            LOG.error(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }

}
