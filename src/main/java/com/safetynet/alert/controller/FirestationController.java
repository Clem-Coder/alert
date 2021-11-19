package com.safetynet.alert.controller;

import com.safetynet.alert.model.Firestation;
import com.safetynet.alert.model.Person;
import com.safetynet.alert.model.alerts.firestationAlert.FirestationAlert;
import com.safetynet.alert.service.FirestationService;
import com.safetynet.alert.service.PersonService;
import com.safetynet.alert.service.PersonsSortingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class FirestationController {

    private static final Logger logger = LogManager.getLogger("FirestationController");

    @Autowired
    FirestationService firestationService;

    @Autowired
    PersonService personService;

    @Autowired
    PersonsSortingService personsSortingService;

    @GetMapping("/firestations")
    public Iterable<Firestation> getFirestations(){
        logger.info("New request: search all Firestations in database");
        return firestationService.getFirestations();
    }

    @GetMapping("/firestation")
    public FirestationAlert getFirestationAlertByStationNumber(@RequestParam("stationNumber") int stationNumber) throws ParseException {
        logger.info("New request: get FirestationAlert with station number -> Station_number: " + stationNumber);
        return personsSortingService.getFirestationAlertByPersonsList(personService.getPersonsByFirestationList(firestationService.getFirestationsByStationNumber(stationNumber)));
    }

//    @PutMapping("/firestation")
//    public Iterable<Firestation> getFirestations(@RequestBody String address){
//        logger.info("Call getFirestations() method of FirestationController");
//        return firestationService.getFirestations();
//    }
}
