package edu.hneu.kpp.lab2.spring.service.service.implementation;

import edu.hneu.kpp.lab2.spring.dao.entity.PublishingHouseEntity;
import edu.hneu.kpp.lab2.spring.dao.repository.PublishingHouseRepository;
import edu.hneu.kpp.lab2.spring.service.service.PublishingHouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PublishingHouseServiceImpl implements PublishingHouseService {
    @Resource
    private PublishingHouseRepository publishingHouseRepository;

    @Override
    public PublishingHouseEntity save(PublishingHouseEntity publishingHouseEntity) {
        return publishingHouseRepository.saveAndFlush(publishingHouseEntity);
    }

    @Override
    public void delete(PublishingHouseEntity publishingHouseEntity) {
        publishingHouseRepository.delete(publishingHouseEntity);
    }

    @Override
    public void deleteAll() {
        publishingHouseRepository.deleteAll();
    }

    @Override
    public PublishingHouseEntity findById(Integer id) {
        return publishingHouseRepository.findById(id).orElse(null);
    }

    @Override
    public List<PublishingHouseEntity> findAll() {
        return publishingHouseRepository.findAll();
    }
}

