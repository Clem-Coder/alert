package com.safetynet.alert.service;

import com.safetynet.alert.model.Firestation;
import com.safetynet.alert.model.Person;
import com.safetynet.alert.model.idclasses.MedicalrecordAndPersonId;
import com.safetynet.alert.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private static final Logger logger = LogManager.getLogger("PersonService");

    @Autowired
    PersonRepository personRepository;

    public Iterable<Person> savePersons(List<Person> personList) {
        List<String> persons = new ArrayList<>();
        for (Person p : personList){
            persons.add(p.getFirstName() + " " + p.getLastName());
        }
        logger.debug("Using saveAll() method of PersoRepository");
        logger.info("Persons saved in database: " + persons);
        return personRepository.saveAll(personList);
    }

    public Person savePerson(Person person) {
        logger.debug("Using save() method of PersoRepository");
        logger.info("Person saved in database: " + person);
        return personRepository.save(person);
    }

    public Person updatePerson(Person person) {
        logger.debug("Using save() method of PersoRepository to update person");
        logger.info("Person updated in database: " + person);
        return personRepository.save(person);
    }

    public void deletePerson(MedicalrecordAndPersonId id) {
        logger.debug("Using deleteById() method of PersoRepository");
        logger.info("Person deleted from database: " + id);
        personRepository.deleteById(id);
    }

    public Iterable<Person> getPersons() {
        Iterable<Person> personList = personRepository.findAll();
        List<String> persons = new ArrayList<>();
        for (Person p : personList){
            persons.add(p.getFirstName() + " " + p.getLastName());
        }
        logger.debug("Using findAll() method of PersoRepository");
        logger.info("Persons in database are: " + persons);
        return personList;
    }

    public Iterable<Person> getPersonsByAddress(String address) {
        Iterable<Person> personList = personRepository.findByAddress(address);
        logger.debug("Using findByAddress() method of PersoRepository");
        logger.info("Persons who live in this address: " + address + ",are: " + personList);
        return personList;
    }

    public Iterable<Person> getPersonsByCity(String city) {
        Iterable<Person> personList = personRepository.findByCity(city);
        logger.debug("Using findByCity() method of PersoRepository");
        logger.info("Persons who live in " + city + " are: " + personList);
        return personList;
    }

    public Iterable<Person> getPersonsByFirstNameAndLastName(String firstName, String lastName) {
        logger.debug("Using getPersonsByFirstNameAndLastName() method of PersoRepository for" + firstName + " " + lastName );
        return personRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Person> getPersonsByFirestationList(Iterable<Firestation> firestationsList) {
        List<Person> personsFromFirestationsList = new ArrayList<>();
        List<String> persons = new ArrayList<>();
        for (Firestation firestation : firestationsList) {
            List<Person> personList = firestation.getPersons();
            for (Person person : personList) {
                personsFromFirestationsList.add(person);
                persons.add(person.getFirstName() + " " + person.getLastName());
            }
        }
        logger.debug("Using getPersonsByFirestationList() method of PersoRepository");
        logger.debug("Persons in FirestationList are: " + persons);
        return personsFromFirestationsList;
    }

}


