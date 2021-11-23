package com.safetynet.alert.model.alerts.firestationAlert;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class FirestationAlertModel {

    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    public String toString(){
        return "firstname:" + this.firstName + ", lastName:" + this.lastName + ", address:" + this.address + ", phone:" + this.phone;
    }


}
