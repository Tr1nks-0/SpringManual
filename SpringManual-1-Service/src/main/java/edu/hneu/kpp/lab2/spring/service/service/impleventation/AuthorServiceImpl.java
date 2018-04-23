package edu.hneu.kpp.lab2.spring.service.service.impleventation;

import edu.hneu.kpp.lab2.spring.dao.entity.AuthorEntity;
import edu.hneu.kpp.lab2.spring.dao.repository.AuthorRepository;
import edu.hneu.kpp.lab2.spring.service.service.AuthorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Resource
    private AuthorRepository authorRepository;

    @Override
    public AuthorEntity save(AuthorEntity author) {
        return authorRepository.saveAndFlush(author);
    }

    @Override
    public void delete(AuthorEntity author) {
        authorRepository.delete(author);
    }

    @Override
    public void deleteAll() {
        authorRepository.deleteAll();
    }

    @Override
    public AuthorEntity findById(Integer id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<AuthorEntity> findAll() {
        return authorRepository.findAll();
    }
}
