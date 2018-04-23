package edu.hneu.kpp.lab2.spring.dao.repository;

import edu.hneu.kpp.lab2.spring.dao.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
}

