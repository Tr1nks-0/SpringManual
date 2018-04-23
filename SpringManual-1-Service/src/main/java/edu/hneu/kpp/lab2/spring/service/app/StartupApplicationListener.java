package edu.hneu.kpp.lab2.spring.service.app;

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
import java.util.List;

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
        test();
    }

    public void test() {
        AuthorEntity author1 = authorService.save(new AuthorEntity("Fyodor", "Dostoevsky"));
        AuthorEntity author2 = authorService.save(new AuthorEntity("Leo", "Tolstoy"));
        AuthorEntity author3 = authorService.save(new AuthorEntity("Jane", "Austen"));
        BookEntity book1 = bookService.save(new BookEntity("The Brothers Karamazov", author1));
        BookEntity book2 = bookService.save(new BookEntity("War and Peace", author2));
        BookEntity book3 = bookService.save(new BookEntity("Pride and Prejudice", author3));
        PublishingHouseEntity publishingHouse1 =
                publishingHouseService.save(new PublishingHouseEntity("Star PH", new HashSet<>(Arrays.asList(book1, book2))));
        PublishingHouseEntity publishingHouse2 =
                publishingHouseService.save(new PublishingHouseEntity("Kharkov Central PH", new HashSet<>(Arrays.asList(book2, book3))));

        List<PublishingHouseEntity> publishingHouseEntities = publishingHouseService.findAll();
        for (PublishingHouseEntity pe : publishingHouseEntities) {
            System.out.println("##########################################################");
            System.out.println(pe);
            System.out.println("--------------------------");
            pe.getBookEntities().forEach(bookEntity -> System.out.printf("%75s  ---  %25s" + System.lineSeparator(), bookEntity, bookEntity.getAuthorEntity()));
        }
//        bookService.deleteAll();
//        authorService.deleteAll();
//        publishingHouseService.deleteAll();
    }
}

