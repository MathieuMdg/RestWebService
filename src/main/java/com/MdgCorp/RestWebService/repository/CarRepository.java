package com.MdgCorp.RestWebService.repository;

import com.MdgCorp.RestWebService.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
    public Car getById(Long carID);
}
