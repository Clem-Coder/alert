package com.safetynet.alert.controller;

import com.safetynet.alert.model.Person;
import com.safetynet.alert.model.alerts.childAlert.ChildAlert;
import com.safetynet.alert.model.alerts.communityEmailAlert.CommunityEmailAlert;
import com.safetynet.alert.model.alerts.fireAlert.FireAlert;
import com.safetynet.alert.model.alerts.floodAlert.FloodAlert;
import com.safetynet.alert.model.alerts.personInfoAlert.PersonInfoAlert;
import com.safetynet.alert.model.alerts.phoneAlert.PhoneAlert;
import com.safetynet.alert.model.idclasses.MedicalrecordAndPersonId;
import com.safetynet.alert.service.FirestationService;
import com.safetynet.alert.service.PersonService;
import com.safetynet.alert.service.PersonsSortingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class PersonController {

    private static final Logger logger = LogManager.getLogger("PersonController");

    @Autowired
    PersonService personService;

    @Autowired
    FirestationService firestationService;

    @Autowired
    PersonsSortingService personsSortingService;

    @GetMapping("/persons")
    public Iterable<Person> getPersons() {
        logger.info("New request: search all Persons in database");
        return personService.getPersons();
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        logger.info("New request: save new Person in database -> firstName: " + person.getFirstName() + ", lastName: " + person.getLastName());
        return personService.savePerson(person);
    }

    @PutMapping("/person")
    public Person uptadePerson(@RequestBody Person person) {
        logger.info("New request: update one Person in database -> firstName: " + person.getFirstName() + ", lastName: " + person.getLastName());
        return personService.updatePerson(person);
    }

    @DeleteMapping("/person")
    public void deletePerson(@RequestBody MedicalrecordAndPersonId id) {
        logger.info("New request: delete Person from database -> firstName: " + id.getFirstName() + ", lastName: " + id.getLastName());
        personService.deletePerson(id);
    }

    @GetMapping("/childAlert")
    public List<ChildAlert> getChildAlertByAdress(@RequestParam("address") String address) throws ParseException {
        logger.info("New request: get childAlert with address: " + address);
        return personsSortingService.getChildAlertByPersonsList(personService.getPersonsByAddress(address));
    }

    @GetMapping("/phoneAlert")
    public PhoneAlert getPhoneAlertByStationNumber(@RequestParam("firestation") int stationNumber) throws ParseException {
        logger.info("New request: get phoneAlert with firestation number: " + stationNumber);
        return personsSortingService.getPhoneAlertByPersonsList(personService.getPersonsByFirestationList(firestationService.getFirestationsByStationNumber(stationNumber)));
    }

    @GetMapping("/fire")
    public FireAlert getFireAlertByStationAddress(@RequestParam("address") String address) throws ParseException {
        logger.info("New request: get fireAlert with address: " + address);
        return personsSortingService.getFireAlertByPersonsList(personService.getPersonsByFirestationList(firestationService.getFirestationsByAddress(address)));
    }

    @GetMapping("/personInfo")
    public PersonInfoAlert getPersonInfoAlertByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName ) throws ParseException {
        logger.info("New request: search PersonInfoAlert with firstName: " + firstName + ", lastName: " + lastName);
        return personsSortingService.getPersonInfoAlertByPersonsList(personService.getPersonsByFirstNameAndLastName(firstName,lastName));
    }

    @GetMapping("/communityEmail")
    public CommunityEmailAlert getCommunityEmailAlertByStationNumber(@RequestParam("city") String city) {
        logger.info("New request: get communityEmailAlert with city: " + city);
        return personsSortingService.getCommunityEmailAlertByPersonsList(personService.getPersonsByCity(city));
    }

    @GetMapping("/flood/stations")
    public FloodAlert getFloodAlertByStationNumber(@RequestParam("stations") List<Integer> stationNumbers) throws ParseException {
        logger.info("New request: get floodAlert with station_numbers: " + stationNumbers);
        return personsSortingService.getFloodAlertByPersonsList(personService.getPersonsByFirestationList(firestationService.getFirestationsByListOfStationNumbers(stationNumbers)));
    }

}

