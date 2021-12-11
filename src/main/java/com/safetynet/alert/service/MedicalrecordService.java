package com.safetynet.alert.service;

import com.safetynet.alert.model.Medicalrecord;
import com.safetynet.alert.model.Person;
import com.safetynet.alert.model.idclasses.MedicalrecordAndPersonId;
import com.safetynet.alert.repository.MedicalrecordRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalrecordService {

    /**
     * here are all the methods use to manipulate (Create,read, update & delete) datas from medicalrecord table
     */

    private static final Logger logger = LogManager.getLogger("MedicalrecordService");

    @Autowired
    MedicalrecordRepository medicalrecordRepository;


    public Iterable<Medicalrecord> getMedicalrecords(){
        Iterable<Medicalrecord> medicalrecordList = medicalrecordRepository.findAll();
        List<String> medicalrecords = new ArrayList<>();
        for (Medicalrecord m : medicalrecordList){
            medicalrecords.add(m.getFirstName() + " " + m.getLastName());
        }
        logger.info("Medicalrecords in database are: " + medicalrecords);
        return medicalrecordList;
    }

    public Iterable<Medicalrecord> saveMedicalrecords(List<Medicalrecord> medicalrecords){
        Iterable<Medicalrecord> medicalrecordList = medicalrecordRepository.saveAll(medicalrecords);
        logger.info("Medicalrecords save in database: " + medicalrecordList);
        return medicalrecordList;
    }

    public Medicalrecord saveMedicalrecord (Medicalrecord medicalrecord){
        logger.info("Medicalrecord save in database -> FirstName: " + medicalrecord.getFirstName() + ", LastName: " + medicalrecord.getLastName());
        return medicalrecordRepository.save(medicalrecord);
    }

    public void deleteMedicalrecord(MedicalrecordAndPersonId id) {
        logger.info("Medicalrecords deleted from database -> FirstName: " + id.getFirstName() + ", LastName: " + id.getLastName());
        medicalrecordRepository.deleteById(id);
    }

    public Medicalrecord updateMedicalrecord(Medicalrecord medicalrecord) {
        logger.info("Medicalrecords updated in database -> FirstName: " + medicalrecord.getFirstName() + ", LastName: " + medicalrecord.getLastName());
        return medicalrecordRepository.save(medicalrecord);
    }
}
