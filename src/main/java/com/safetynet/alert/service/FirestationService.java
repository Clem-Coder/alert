package com.safetynet.alert.service;

import com.safetynet.alert.model.Firestation;
import com.safetynet.alert.model.Person;
import com.safetynet.alert.repository.FirestationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FirestationService {

    private static final Logger logger = LogManager.getLogger("FirestationService");

    @Autowired
    FirestationRepository firestationRepository;

    public Iterable<Firestation> saveFirestations(List<Firestation> firestations) {
        logger.info("Firestations add in database" + firestations);
        return firestationRepository.saveAll(firestations);
    }

    public Iterable<Firestation> getFirestations() {
        Iterable<Firestation> firestationList = firestationRepository.findAllByOrderByStationAsc();
        logger.info("Firestations in database are " + firestationList);
        return firestationList;
    }

    public Iterable<Firestation> getFirestationsByStationNumber(int stationNumber) {
        Iterable<Firestation> firestationList = firestationRepository.findByStation(stationNumber);
        logger.info("Firestations with this station number: " + stationNumber + ",are: " + firestationList);
        return firestationList;
    }

    public List<Firestation> getFirestationsByListOfStationNumbers (List<Integer> stationNumberList) {
        List<Firestation> firestationList = new ArrayList<>();
        for (Integer stationNumber : stationNumberList){
            Iterable<Firestation> firestations = new ArrayList<>();
            firestations = firestationRepository.findByStation(stationNumber);
            for(Firestation firestation : firestations)
                firestationList.add(firestation);
        }
        logger.info("Firestations with station_numbers: " + stationNumberList + ",are: " + firestationList);
        return firestationList;

    }

    public Iterable<Firestation> getFirestationsByAddress(String address) {
        Iterable<Firestation> firestationList = firestationRepository.findByAddress(address);
        logger.info("Firestation with this address: " + address + ",is: " + firestationList);
        return firestationList;
    }

    public int getStationNumberByAddress(String address) {
        Iterable<Firestation> firestationList = firestationRepository.findByAddress(address);
        Firestation firestation = new Firestation();
        for (Firestation firestationInList : firestationList)
            firestation = firestationInList;
        logger.info("The station number, with the station in this address: " + address + ",is: " + firestationList);
        return firestation.getStation();
    }
}
