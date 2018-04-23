package edu.hneu.kpp.lab2.spring.service.service.impleventation;

import edu.hneu.kpp.lab2.spring.dao.entity.BookEntity;
import edu.hneu.kpp.lab2.spring.dao.repository.BookRepository;
import edu.hneu.kpp.lab2.spring.service.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookRepository bookRepository;

    @Override
    public BookEntity save(BookEntity book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public void delete(BookEntity book) {
        bookRepository.delete(book);
    }

    @Override
    public void deleteAll() {
        bookRepository.deleteAll();
    }

    @Override
    public BookEntity findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }
}
