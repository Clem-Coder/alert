package com.safetynet.alert.model.alerts.fireAlert;

import lombok.Data;

import javax.persistence.ElementCollection;
import java.util.List;

@Data
public class FireAlertModel {
    private String firstName;
    private String lastName;
    private String phone;
    private long age;
    private List<String> medications;
    private List<String> allergies;

}
