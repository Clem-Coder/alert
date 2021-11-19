package com.safetynet.alert.model.alerts.childAlert;

import com.safetynet.alert.model.Person;
import lombok.Data;

import java.util.List;

@Data
public class ChildAlert {

    private String address;
    private String firstName;
    private String lastName;
    private long age;
    private List<Person> family;


}
