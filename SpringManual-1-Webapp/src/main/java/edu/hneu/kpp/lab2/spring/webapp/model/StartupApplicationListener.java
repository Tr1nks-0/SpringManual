package edu.hneu.kpp.lab2.spring.webapp.model;

import edu.hneu.kpp.lab2.spring.dao.entity.AuthorEntity;
import edu.hneu.kpp.lab2.spring.dao.entity.BookEntity;
import edu.hneu.kpp.lab2.spring.dao.entity.PublishingHouseEntity;
import edu.hneu.kpp.lab2.spring.service.service.AuthorService;
import edu.hneu.kpp.lab2.spring.service.service.BookService;
import edu.hneu.kpp.lab2.spring.service.service.PublishingHouseService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class StartupApplicationListener implements ApplicationRunner {
    @Resource
    private BookService bookService;
    @Resource
    private AuthorService authorService;
    @Resource
    private PublishingHouseService publishingHouseService;

    @Override
    public void run(ApplicationArguments args) {
        initFillDB();
    }

    public void initFillDB() {
        AuthorEntity author1 = authorService.save(new AuthorEntity("Fyodor", "Dostoevsky"));
        AuthorEntity author2 = authorService.save(new AuthorEntity("Leo", "Tolstoy"));
        AuthorEntity author3 = authorService.save(new AuthorEntity("Jane", "Austen"));
        BookEntity book1 = bookService.save(new BookEntity("The Brothers Karamazov", author1));
        BookEntity book2 = bookService.save(new BookEntity("War and Peace", author2));
        BookEntity book3 = bookService.save(new BookEntity("Anna Karenina", author2));
        BookEntity book4 = bookService.save(new BookEntity("Pride and Prejudice", author3));
        publishingHouseService.save(new PublishingHouseEntity("Star PH", new HashSet<>(Arrays.asList(book1, book2, book4))));
        publishingHouseService.save(new PublishingHouseEntity("Kharkov Central PH", new HashSet<>(Arrays.asList(book2, book3))));
    }
}
