package com.safetynet.alert;

import com.safetynet.alert.repository.MedicalrecordRepository;
import com.safetynet.alert.service.FirestationService;
import com.safetynet.alert.service.JsonReaderService;
import com.safetynet.alert.service.MedicalrecordService;
import com.safetynet.alert.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SafetynetalertsApplicationRunner implements CommandLineRunner {

    private static final Logger logger = LogManager.getLogger("SafetynetalertsApplicationRunner");

    @Autowired
    PersonService personService;

    @Autowired
    FirestationService firestationService;

    @Autowired
    MedicalrecordService medicalrecordService;

    @Override
    public void run(String... args) throws Exception {

        logger.info("Put data in database");
        JsonReaderService jsonReaderService = new JsonReaderService();
        personService.savePersons(jsonReaderService.readPersonsFromJsonFile());
        System.out.println("Insert Persons in database ");
        firestationService.saveFirestations(jsonReaderService.readFirestationsFromJsonFile());
        System.out.println("Insert Firestations in database ");
        medicalrecordService.saveMedicalrecords(jsonReaderService.readMedicalrecordsFromJsonFile());
        System.out.println("Insert Medicalrecords in database ");

    }
}
