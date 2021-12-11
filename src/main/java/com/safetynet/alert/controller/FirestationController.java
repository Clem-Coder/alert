package com.safetynet.alert.controller;

import com.safetynet.alert.model.Firestation;
import com.safetynet.alert.model.Person;
import com.safetynet.alert.model.alerts.firestationAlert.FirestationAlert;
import com.safetynet.alert.model.idclasses.FirestationId;
import com.safetynet.alert.model.idclasses.MedicalrecordAndPersonId;
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

    /**
     * here are all the methods use to manipulate (Create,read, update & delete) datas from firestation table
     */

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

    @PostMapping("/firestation")
    public Firestation addFirestation(@RequestBody Firestation firestation) {
        logger.info("New request: save new Firestation in database -> Address: " + firestation.getAddress() + ", station_number: " + firestation.getStation());
        return firestationService.saveFirestation(firestation);
    }

    @PutMapping("/firestation")
    public Firestation uptadeFirestation(@RequestBody Firestation firestation) {
        logger.info("New request: update one Firestation in database -> Address: " + firestation.getAddress() + ", station_number: " + firestation.getStation());
        return firestationService.updateFirestation(firestation);
    }

    @DeleteMapping("/firestation")
    public void deleteFirestation(@RequestBody FirestationId id) {
        logger.info("New request: delete Firestation from database -> Address: " + id.getAddress() );
        firestationService.deleteFirestation(id);
    }
}

