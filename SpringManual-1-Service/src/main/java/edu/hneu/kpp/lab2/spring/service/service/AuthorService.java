package edu.hneu.kpp.lab2.spring.service.service;

import edu.hneu.kpp.lab2.spring.dao.entity.AuthorEntity;

import java.util.List;

public interface AuthorService {
    AuthorEntity save(AuthorEntity author);

    void delete(AuthorEntity author);

    void deleteAll();

    AuthorEntity findById(Integer id);

    List<AuthorEntity> findAll();
}
