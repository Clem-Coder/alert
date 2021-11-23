package com.safetynet.alert.controller;

import com.safetynet.alert.model.Medicalrecord;
import com.safetynet.alert.model.Person;
import com.safetynet.alert.model.idclasses.MedicalrecordAndPersonId;
import com.safetynet.alert.service.MedicalrecordService;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicalrecordController {

    private static final Logger logger = LogManager.getLogger("MedicalrecordController");

    @Autowired
    MedicalrecordService medicalrecordService;

    @GetMapping("/medicalRecords")
    Iterable<Medicalrecord> getMedicalrecords(){
        logger.info("New request: search all Medicalrecords in database");
        return medicalrecordService.getMedicalrecords();
    }

    @PostMapping("/medicalRecord")
    Medicalrecord addMedicalrecord(@RequestBody Medicalrecord medicalrecord) {
        logger.info("New request: Add Medicalrecord in database: FirstName: " + medicalrecord.getFirstName() +", lastName: "+ medicalrecord.getLastName());
        return medicalrecordService.saveMedicalrecord(medicalrecord);
    }

    @PutMapping("/medicalRecord")
    public Medicalrecord uptadeMedicalrecord(@RequestBody Medicalrecord medicalrecord) {
        logger.info("New request: Update Medicalrecord in database: FirstName: " + medicalrecord.getFirstName() +", lastName: "+ medicalrecord.getLastName());
        return medicalrecordService.updateMedicalrecord(medicalrecord);
    }

    @DeleteMapping("/medicalRecord")
    public void deleteMedicalrecord(@RequestBody MedicalrecordAndPersonId id) {
        logger.info("New request: Delete Medicalrecord from database: FirstName: " + id.getFirstName() +", lastName: "+ id.getLastName());
        medicalrecordService.deleteMedicalrecord(id);
    }

}

