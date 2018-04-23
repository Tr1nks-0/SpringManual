package edu.hneu.kpp.lab2.spring.webapp.model.config;

import edu.hneu.kpp.lab2.spring.dao.entity.BookEntity;
import edu.hneu.kpp.lab2.spring.service.service.BookService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StartupApplicationListener implements ApplicationRunner {
    @Resource
    private BookService bookService;

    @Override
    public void run(ApplicationArguments args) {
        initFillDB();
    }

    public void initFillDB() {
        BookEntity book1 = bookService.save(new BookEntity("The Brothers Karamazov", "Fyodor Dostoevsky"));
        BookEntity book2 = bookService.save(new BookEntity("War and Peace", "Leo Tolstoy"));
        BookEntity book3 = bookService.save(new BookEntity("Pride and Prejudice", "Jane Austen"));
    }
}
