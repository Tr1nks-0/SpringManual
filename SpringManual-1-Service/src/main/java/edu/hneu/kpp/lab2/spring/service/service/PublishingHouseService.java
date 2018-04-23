package edu.hneu.kpp.lab2.spring.service.service;

import edu.hneu.kpp.lab2.spring.dao.entity.PublishingHouseEntity;

import java.util.List;

public interface PublishingHouseService {
    PublishingHouseEntity save(PublishingHouseEntity book);

    void delete(PublishingHouseEntity book);

    void deleteAll();

    PublishingHouseEntity findById(Integer id);

    List<PublishingHouseEntity> findAll();
}
