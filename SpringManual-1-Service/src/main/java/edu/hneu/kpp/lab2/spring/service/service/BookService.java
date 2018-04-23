package edu.hneu.kpp.lab2.spring.service.service;

import edu.hneu.kpp.lab2.spring.dao.entity.BookEntity;

import java.util.List;

public interface BookService {
    BookEntity save(BookEntity book);

    void delete(BookEntity book);

    void deleteAll();

    BookEntity findById(Integer id);

    List<BookEntity> findAll();
}
