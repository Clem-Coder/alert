package com.safetynet.alert.service;

import com.safetynet.alert.model.Person;
import com.safetynet.alert.model.alerts.childAlert.ChildAlert;
import com.safetynet.alert.model.alerts.communityEmailAlert.CommunityEmailAlert;
import com.safetynet.alert.model.alerts.fireAlert.FireAlert;
import com.safetynet.alert.model.alerts.fireAlert.FireAlertModel;
import com.safetynet.alert.model.alerts.firestationAlert.FirestationAlert;
import com.safetynet.alert.model.alerts.firestationAlert.FirestationAlertModel;
import com.safetynet.alert.model.alerts.floodAlert.FloodAlert;
import com.safetynet.alert.model.alerts.floodAlert.FloodAlertModel;
import com.safetynet.alert.model.alerts.personInfoAlert.PersonInfoAlert;
import com.safetynet.alert.model.alerts.phoneAlert.PhoneAlert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.safetynet.alert.model.constants.DateConstant.EIGHTEEN_YEARS_IN_MILLISECONDS;
import static com.safetynet.alert.model.constants.DateConstant.ONE_YEAR_IN_MILLISECONDS;

@Service
public class PersonsSortingService {

    private static final Logger logger = LogManager.getLogger("PersonsSortingService");

    @Autowired
    FirestationService firestationService;

    public FirestationAlert getFirestationAlertByPersonsList(List<Person> personList)  {
        FirestationAlert firestationAlert = new FirestationAlert();
        List<FirestationAlertModel> firestationAlertsModelList = new ArrayList<>();
        int number_of_childs = 0;
        int number_of_adults = 0;
        for (Person person : personList) {
            FirestationAlertModel firestationAlertModel = new FirestationAlertModel();
            Date date = new Date();
            Date birthdate = null;
            try {
                birthdate = new SimpleDateFormat("dd/MM/yyyy").parse(person.getMedicalrecord().getBirthdate());
            } catch (ParseException e) {
                logger.error("Error, can't parsing String -> Date in getFirestationAlertByPersonsList() method " + e.getMessage()); }
            if (date.getTime() - birthdate.getTime() < EIGHTEEN_YEARS_IN_MILLISECONDS)
                number_of_childs++;
            else
                number_of_adults++;
            firestationAlertModel.setAddress(person.getAddress());
            firestationAlertModel.setFirstName(person.getFirstName());
            firestationAlertModel.setLastName(person.getLastName());
            firestationAlertModel.setPhone(person.getPhone());
            firestationAlertsModelList.add(firestationAlertModel);
        }
        firestationAlert.setNumber_of_childs(number_of_childs);
        firestationAlert.setNumber_of_adults(number_of_adults);
        firestationAlert.setPersons_list(firestationAlertsModelList);

        logger.info("FirestationAlert: " + firestationAlert);
        return firestationAlert;
    }

    public List<ChildAlert> getChildAlertByPersonsList(Iterable<Person> personList)  {
        List<ChildAlert> childAlertList = new ArrayList<>();
        for (Person person : personList) {
            List<Person> family = new ArrayList<>();
            ChildAlert childAlert = new ChildAlert();
            Date date = new Date();
            Date birthdate = null;
            try {
                birthdate = new SimpleDateFormat("dd/MM/yyyy").parse(person.getMedicalrecord().getBirthdate());
            } catch (ParseException e) {
                logger.error("Error, can't parsing String -> Date in getChildAlertByPersonsList() method " + e.getMessage());
            }

            if (date.getTime() - birthdate.getTime() < EIGHTEEN_YEARS_IN_MILLISECONDS) {
                long age = (date.getTime() - birthdate.getTime()) / ONE_YEAR_IN_MILLISECONDS;
                childAlert.setAge(age);
                childAlert.setAddress(person.getAddress());
                childAlert.setFirstName(person.getFirstName());
                childAlert.setLastName(person.getLastName());

                for (Person otherMember : personList)
                    if (otherMember.getFirstName() != person.getFirstName())
                        family.add(otherMember);

                childAlert.setFamily(family);
                childAlertList.add(childAlert);
            }
        }
        logger.info("ChildAlerts are: " + childAlertList);
        return childAlertList;
    }

    public PhoneAlert getPhoneAlertByPersonsList(Iterable<Person> personList) {
        PhoneAlert phoneAlert = new PhoneAlert();
        List<String> phone_list = new ArrayList<>();
        for (Person person : personList) {
            phone_list.add(person.getPhone());
        }
        phoneAlert.setPhones_list(phone_list);

        logger.info("PhoneAlert: " + phoneAlert);
        return phoneAlert;
    }

    public FireAlert getFireAlertByPersonsList(Iterable<Person> personList)  {
        FireAlert fireAlert = new FireAlert();
        List<FireAlertModel> fireAlertModelsList = new ArrayList<>();
        for (Person person : personList) {

            FireAlertModel fireAlertModel = new FireAlertModel();
            Date date = new Date();
            Date birthdate = null;
            try {
                birthdate = new SimpleDateFormat("dd/MM/yyyy").parse(person.getMedicalrecord().getBirthdate());
            } catch (ParseException e) {
                logger.error("Error, can't parsing String -> Date in getFireAlertByPersonsList() method " + e.getMessage());
            }
            long age = (date.getTime() - birthdate.getTime()) / ONE_YEAR_IN_MILLISECONDS;
            fireAlert.setAddress(person.getAddress());
            fireAlert.setStation_number(firestationService.getStationNumberByAddress(person.getAddress()));
            fireAlertModel.setAge(age);
            fireAlertModel.setFirstName(person.getFirstName());
            fireAlertModel.setLastName(person.getLastName());
            fireAlertModel.setPhone(person.getPhone());
            fireAlertModel.setMedications(person.getMedicalrecord().getMedications());
            fireAlertModel.setAllergies(person.getMedicalrecord().getAllergies());
            fireAlertModelsList.add(fireAlertModel);
        }
        fireAlert.setPersons_list(fireAlertModelsList);
        logger.info("FireAlert: " + fireAlert);
        return fireAlert;
    }

    public PersonInfoAlert getPersonInfoAlertByPersonsList(Iterable<Person> personList)  {
        PersonInfoAlert personInfoAlert = new PersonInfoAlert();
        for (Person person : personList) {
            Date date = new Date();
            Date birthdate = null;
            try {
                birthdate = new SimpleDateFormat("dd/MM/yyyy").parse(person.getMedicalrecord().getBirthdate());
            } catch (ParseException e) {
                logger.error("Error, can't parsing String -> Date in getPersonInfoAlertByPersonsList() method " + e.getMessage());
            }
            long age = (date.getTime() - birthdate.getTime()) / ONE_YEAR_IN_MILLISECONDS;
                personInfoAlert.setAge(age);
                personInfoAlert.setAddress(person.getAddress());
                personInfoAlert.setFirstName(person.getFirstName());
                personInfoAlert.setLastName(person.getLastName());
                personInfoAlert.setEmail(person.getEmail());
                personInfoAlert.setMedications(person.getMedicalrecord().getMedications());
                personInfoAlert.setAllergies(person.getMedicalrecord().getAllergies());
        }
        logger.info("PersonsInfoAlert is: " + personInfoAlert);
        return personInfoAlert;
    }

    public CommunityEmailAlert getCommunityEmailAlertByPersonsList(Iterable<Person> personList) {
        CommunityEmailAlert communityEmailAlert = new CommunityEmailAlert();
        List<String> emailsList = new ArrayList<>();
        for(Person person : personList){
            emailsList.add(person.getEmail());
        }
        communityEmailAlert.setEmails(emailsList);
        logger.info("communityEmailAlert : " + communityEmailAlert);
        return communityEmailAlert;
    }

    public FloodAlert getFloodAlertByPersonsList(Iterable<Person> personList)  {
        FloodAlert floodAlert = new FloodAlert();
        List<Integer> stationNumberList = new ArrayList<>();
        List<FloodAlertModel> floodAlertModelList = new ArrayList<>();
        int stationNumber = 0;
        for (Person person : personList) {
            FloodAlertModel floodAlertModel= new FloodAlertModel();
            Date date = new Date();
            Date birthdate = null;
            try {
                birthdate = new SimpleDateFormat("dd/MM/yyyy").parse(person.getMedicalrecord().getBirthdate());
            } catch (ParseException e) {
                logger.error("Error, can't parsing String -> Date in getFloodAlertByPersonsList() method " + e.getMessage());
            }
            long age = (date.getTime() - birthdate.getTime()) / ONE_YEAR_IN_MILLISECONDS;
            if (stationNumber !=firestationService.getStationNumberByAddress(person.getAddress()) )
                stationNumberList.add(firestationService.getStationNumberByAddress(person.getAddress()));
            stationNumber = firestationService.getStationNumberByAddress(person.getAddress());
            floodAlertModel.setAge(age);
            floodAlertModel.setFirstName(person.getFirstName());
            floodAlertModel.setLastName(person.getLastName());
            floodAlertModel.setPhone(person.getPhone());
            floodAlertModel.setMedications(person.getMedicalrecord().getMedications());
            floodAlertModel.setAllergies(person.getMedicalrecord().getAllergies());
            floodAlertModelList.add(floodAlertModel);
            floodAlert.setPersons_list(floodAlertModelList);
            floodAlert.setStation_numbers(stationNumberList);
        }
        logger.info("FloodAlert: " + floodAlert);
        return floodAlert;
    }
}
