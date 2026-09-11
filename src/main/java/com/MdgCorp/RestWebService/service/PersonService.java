package com.MdgCorp.RestWebService.service;

import com.MdgCorp.RestWebService.entity.Contract;
import com.MdgCorp.RestWebService.entity.Person;
import com.MdgCorp.RestWebService.exception.NotSavedInDatabase;
import com.MdgCorp.RestWebService.repository.ContractRepository;
import com.MdgCorp.RestWebService.repository.PersonRepository;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class PersonService {

    //Attributes
    // Specify in logs
    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    // Service access UserRepository
    private final PersonRepository personRepository;
    private final ContractRepository contractRepository;

    //Constructors
    public PersonService(PersonRepository personRepository, ContractRepository contractRepository){
        this.personRepository = personRepository;
        this.contractRepository = contractRepository;
    }


    //Methods
    public void addPerson(Person person){
        try {
            personRepository.save(person);
            log.warn("Person added : {}", person);
        }
        catch (Exception e) {
            throw new NotSavedInDatabase("Can't add person in database : " + e.getMessage());
        }
    }

    public List<Person> getPersons(){
        return (List<Person>) personRepository.findAll();
    }
}
