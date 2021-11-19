package com.safetynet.alert.model.alerts.floodAlert;

import lombok.Data;

import java.util.List;

@Data
public class FloodAlertModel {

    private String firstName;
    private String lastName;
    private String phone;
    private long age;
    private List<String> medications;
    private List<String> allergies;
}
