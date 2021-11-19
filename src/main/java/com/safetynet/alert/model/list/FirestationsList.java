package com.safetynet.alert.model.list;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.safetynet.alert.model.Firestation;
import com.safetynet.alert.model.Person;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FirestationsList {

    private List<Firestation> firestations = new ArrayList<Firestation>();

    public FirestationsList(){
        this.firestations = new ArrayList<Firestation>();
    }

    public List<Firestation> getFirestations() {
        return firestations;
    }

    public void setPersons(List<Person> persons) {
        this.firestations = firestations;
    }
}
