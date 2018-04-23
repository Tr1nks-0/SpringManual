package edu.hneu.kpp.lab2.spring.service.app;

import edu.hneu.kpp.lab2.spring.dao.entity.AuthorEntity;
import edu.hneu.kpp.lab2.spring.dao.entity.BookEntity;
import edu.hneu.kpp.lab2.spring.service.service.AuthorService;
import edu.hneu.kpp.lab2.spring.service.service.BookService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StartupApplicationListener implements ApplicationRunner {
    @Resource
    private BookService bookService;
    @Resource
    private AuthorService authorService;

    @Override
    public void run(ApplicationArguments args) {
        test();
    }

    public void test() {
        System.out.println("###### Saving author to db start ######");
        AuthorEntity author1 = authorService.save(new AuthorEntity("Fyodor", "Dostoevsky"));
        AuthorEntity author2 = authorService.save(new AuthorEntity("Leo", "Tolstoy"));
        AuthorEntity author3 = authorService.save(new AuthorEntity("Jane", "Austen"));
        System.out.println("###### Saving author to db finish ######");
        System.out.println("###### Saving book to db start ######");
        BookEntity book1 = bookService.save(new BookEntity("The Brothers Karamazov", author1));
        BookEntity book2 = bookService.save(new BookEntity("War and Peace", author2));
        BookEntity book3 = bookService.save(new BookEntity("Pride and Prejudice", author3));
        System.out.println("###### Saving book to db finish ######");
        System.out.println("###### FindAll - start ######");
        bookService.findAll().forEach(System.out::println);
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
        System.out.println("Books found are :");
        bookService.findAll().forEach(System.out::println);
        System.out.println("###### FindAll - end ######");
        System.out.println("###### Authors ######");
        System.out.println("###### FindAll - start ######");
        authorService.findAll().forEach(System.out::println);
        System.out.println("###### FindAll - end ######");
        System.out.println("###### Books by Authors - start ######");
        authorService.findAll().forEach(author ->
        {
            System.out.println(author);
            author.getBookEntities().forEach(System.out::println);
            System.out.println("==============");
        });
        System.out.println("###### Books by Authors - end ######");
        System.out.println("###### DeleteAll - start ######");
        bookService.deleteAll();
        authorService.deleteAll();
        System.out.println("Books found are now " + bookService.findAll().size());
        System.out.println("Authors found are now " + authorService.findAll().size());
        System.out.println("###### DeleteAll - end ######");
    }
}
