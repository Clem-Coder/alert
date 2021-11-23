package com.safetynet.alert.model.alerts.floodAlert;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FloodAlertModel {

    private String firstName;
    private String lastName;
    private String phone;
    private long age;
    private List<String> medications;
    private List<String> allergies;

    public String toString(){
        return " firstname:" + this.firstName + ", lastName:" + this.lastName + ", phone:" + this.phone + ", age:" + this.age + ", email:" + this.medications + ", allergies:" + this.allergies;
    }
}
