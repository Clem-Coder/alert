package com.safetynet.alert.model.alerts.personInfoAlert;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
public class PersonInfoAlert {

    private String firstName;
    private String lastName;
    private String address;
    private Long age;
    private String email;
    private List<String> medications;
    private List<String> allergies;

    public String toString(){
        return " firstname:" + this.firstName + ", lastName:" + this.lastName + ", address:" + this.address + ", age:" + this.age + ", email:" + this.email + ", medications:" + this.medications + ", allergies:" + this.allergies;
    }

}
