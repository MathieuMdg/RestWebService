package com.MdgCorp.RestWebService.repository;

import org.springframework.data.repository.CrudRepository;
import com.MdgCorp.RestWebService.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
