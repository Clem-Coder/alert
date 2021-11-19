package com.safetynet.alert.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alert.model.Firestation;
import com.safetynet.alert.model.Medicalrecord;
import com.safetynet.alert.model.Person;
import com.safetynet.alert.model.list.FirestationsList;
import com.safetynet.alert.model.list.MedicalRecordsList;
import com.safetynet.alert.model.list.PersonsList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonReaderService {

    private static final Logger logger = LogManager.getLogger("JsonReaderService");
    private ObjectMapper mapper = new ObjectMapper();


    public List<Person> readPersonsFromJsonFile() {
        logger.info("Read Persons From JsonFile");
        String filePath = "C:\\Users\\Clem\\Desktop\\alert\\src\\main\\resources\\data.json";
        File fileSource = new File(filePath);
        PersonsList personsList = new PersonsList();
        try {
            personsList = mapper.readerFor(PersonsList.class).readValue(new File("C:\\Users\\Clem\\Desktop\\alert\\src\\main\\resources\\data.json"));
        } catch (IOException e) {
            System.out.println("Unable to read persons from Json File" + e.getMessage());
        }
        return personsList.getPersons();
    }

    public List<Firestation> readFirestationsFromJsonFile() {
        logger.info("Read Firestations From JsonFile");

        String filePath = "C:\\Users\\Clem\\Desktop\\alert\\src\\main\\resources\\data.json";
        File fileSource = new File(filePath);
        FirestationsList firestationsList = new FirestationsList();
        try {
            firestationsList = mapper.readerFor(FirestationsList.class).readValue(new File("C:\\Users\\Clem\\Desktop\\alert\\src\\main\\resources\\data.json"));
        } catch (IOException e) {
            System.out.println("Unable to read firestations from Json File" + e.getMessage());
        }
        return firestationsList.getFirestations();
    }

    public List<Medicalrecord> readMedicalrecordsFromJsonFile() {
        logger.info("Read Medicalrecords From JsonFile");
        String filePath = "C:\\Users\\Clem\\Desktop\\alert\\src\\main\\resources\\data.json";
        File fileSource = new File(filePath);
        MedicalRecordsList medicalRecordsList= new MedicalRecordsList();
        try {
            medicalRecordsList = mapper.readerFor(MedicalRecordsList.class).readValue(new File("C:\\Users\\Clem\\Desktop\\alert\\src\\main\\resources\\data.json"));
        } catch (IOException e) {
            System.out.println("Unable to read medicalrecords from Json File" + e.getMessage());
        }
        return medicalRecordsList.getMedicalrecords();
    }
}
