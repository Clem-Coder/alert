package com.safetynet.alert.model.alerts.personInfoAlert;

import lombok.Data;

import javax.persistence.Id;
import java.util.List;

@Data
public class PersonInfoAlert {

    private String firstName;
    private String lastName;
    private String address;
    private Long age;
    private String email;
    private List<String> medications;
    private List<String> allergies;
}
