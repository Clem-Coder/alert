package com.safetynet.alert.model.alerts.childAlert;

import com.safetynet.alert.model.Person;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChildAlert {

    private String address;
    private String firstName;
    private String lastName;
    private long age;
    private List<Person> family;

    public String toString(){
        return "firstname:" + this.firstName + ", lastName:" + this.lastName + ", address:" + this.address + ", age:" + this.age +  ", family:" + this.family.toString() ;
    }


}
