package edu.hneu.kpp.lab2.spring.service.app;

import edu.hneu.kpp.lab2.spring.dao.entity.BookEntity;
import edu.hneu.kpp.lab2.spring.service.service.BookService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class StartupApplicationListener implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        test();
    }

    @Resource
    private BookService bookService;

    public void test() {

        //BookEntity book1 = new BookEntity(1, "The Brothers Karamazov", "Fyodor Dostoevsky");
        BookEntity book1 = new BookEntity();
        book1.setTitle("The Brothers Karamazov");
        book1.setAuthor("Fyodor Dostoevsky");

//    BookEntity book2 = new BookEntity(2, "War and Peace", "Leo Tolstoy");
        BookEntity book2 = new BookEntity();
        book2.setTitle("War and Peace");
        book2.setAuthor("Leo Tolstoy");

//    BookEntity book3 = new BookEntity(3, "Pride and Prejudice", "Jane Austen");
        BookEntity book3 = new BookEntity();
        book3.setTitle("Pride and Prejudice");
        book3.setAuthor("Jane Austen");

        System.out.println("###### Saving book to db start ######");
        bookService.save(book1);
        bookService.save(book2);
        bookService.save(book3);
        System.out.println("###### Saving book to db finish ######");
        System.out.println("Find all :");
        List<BookEntity> books1 = bookService.findAll();
        for (BookEntity b : books1) {
            System.out.println("-" + b.toString());
        }
        System.out.println("###### Update - start ######");
        book1.setTitle("The Idiot");
        bookService.save(book1);
        System.out.println("Book Updated is =>" + bookService.findById(book1.getId()).toString());
        System.out.println("###### Update - end ######");
        System.out.println("###### Find - start ######");
        Integer id1 = book1.getId();
        BookEntity another = bookService.findById(id1);
        System.out.println("Book found with id " + id1 + " is =>" + another.toString());
        System.out.println("###### Find - end ######");
        System.out.println("###### Delete - start ######");
        Integer id3 = book3.getId();
        bookService.delete(book3);
        System.out.println("Deleted book with id " + id3 + ".");
        System.out.println("Now all books are " + bookService.findAll().size() + ".");
        System.out.println("###### Delete - end ######");
        System.out.println("###### FindAll - start ######");
        List<BookEntity> books2 = bookService.findAll();
        System.out.println("Books found are :");
        for (BookEntity b : books2) {
            System.out.println("-" + b.toString());
        }
        System.out.println("###### FindAll - end ######");
        System.out.println("###### DeleteAll - start ######");
        bookService.deleteAll();
        System.out.println("Books found are now " + bookService.findAll().size());
        System.out.println("###### DeleteAll - end ######");
    }
}
