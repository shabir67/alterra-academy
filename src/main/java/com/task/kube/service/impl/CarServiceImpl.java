package com.task.kube.service.impl;

import com.task.kube.persistence.CarRepository;
import com.task.kube.persistence.model.Car;
import com.task.kube.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;


@Service
@Transactional
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    public Car create (Car entity) {
        entity.setId(UUID.randomUUID().toString());
        entity.setCreatedDate(new Date());
        entity.setUpdatedDate(new Date());

        return carRepository.save(entity);
    }
}
