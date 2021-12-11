package com.safetynet.alert.repository;

import com.safetynet.alert.model.Person;
import com.safetynet.alert.model.idclasses.MedicalrecordAndPersonId;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository <Person, MedicalrecordAndPersonId> {

    /**
     * here are all the methods used to access and manipulate datas in person table
     */

    public Iterable<Person> findByAddress (String address);

    public Iterable<Person> findByFirstNameAndLastName(String firstName, String lastName);

    public Iterable<Person> findByCity (String city);
}
