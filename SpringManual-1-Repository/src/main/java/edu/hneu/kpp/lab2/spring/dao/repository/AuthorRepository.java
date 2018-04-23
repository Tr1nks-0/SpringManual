package edu.hneu.kpp.lab2.spring.dao.repository;

import edu.hneu.kpp.lab2.spring.dao.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
}
