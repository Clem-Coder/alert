package com.safetynet.alert.model.list;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.safetynet.alert.model.Person;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
    public class PersonsList {

        private List<Person> persons = new ArrayList<Person>();

        public PersonsList(){
            this.persons = new ArrayList<Person>();
        }

        public List<Person> getPersons() {
            return persons;
        }

        public void setPersons(List<Person> persons) {
            this.persons = persons;
        }
    }

