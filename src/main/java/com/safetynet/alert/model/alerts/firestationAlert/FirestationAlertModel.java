package com.safetynet.alert.model.alerts.firestationAlert;

import lombok.Data;

import javax.persistence.Id;

@Data
public class FirestationAlertModel {

    private String firstName;
    private String lastName;
    private String address;
    private String phone;

}
