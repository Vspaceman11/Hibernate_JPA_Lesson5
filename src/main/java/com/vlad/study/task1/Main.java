package com.vlad.study.task1;

import com.vlad.study.task1.entity.Author;
import com.vlad.study.task1.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;


/**
 * Created by Asus on 04.11.2017.
 */
public class Main {

    private static final Logger LOG = LogManager.getLogger(Author.class);

    public static void main(String[] args) {

        AuthorHelper ah = new AuthorHelper();
        BookHelper bh = new BookHelper();

        // Add authors and their books
//        Author author1 = new Author("George", "Orwell");
//        Author author2 = new Author("Richard", "Morgan");
//        ah.addAuthor(author1);
//        ah.addAuthor(author2);
//
//        Book book1 = new Book("1984", author1);
//        Book book2 = new Book("Animal Farm: A Fairy Story", author1);
//        Book book3 = new Book("Altered Carbon", author2);
//        bh.addBook(book1);
//        bh.addBook(book2);
//        bh.addBook(book3);


        System.out.println("----------------------------------------------------");
      // Get Books and author's names using BookHelper Class
//        List<Book> bookList = bh.getBookNameAndAuthorName();
//        for (Book book: bookList) {
//            System.out.println("Book title: " + book.getName()
//                      + " | Author name: " + book.getAuthor().getName() + " " + book.getAuthor().getLastName());
//        }

        System.out.println(ah.getAuthorList());
      // Update author name by id
//        ah.updateAuthor("Christopher", "Nolan", 2);
        System.out.println(ah.getAuthorList());

//        bh.updateBookById("Tenet", 2);
        System.out.println(bh.getBookList());

      // Add lots of Tolkiens using flush every 10 additions
       ah.addAuthorTwoHundredTimes("John Ronald Reuel" ,"Tolkien");
        System.out.println(ah.getAuthorList());



        System.out.println("----------------------------------------------------");

    }

}
