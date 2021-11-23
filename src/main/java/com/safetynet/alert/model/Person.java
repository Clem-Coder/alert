package com.safetynet.alert.model;

import com.safetynet.alert.model.idclasses.MedicalrecordAndPersonId;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity @IdClass(MedicalrecordAndPersonId.class)
public class Person implements Serializable {

    @Id
    private String firstName;
    @Id
    private String lastName;
    private String address;
    private String city;
    private String zip;
    private String phone;
    private String email;

    @Setter(AccessLevel.NONE)
    @OneToOne
    @JoinColumns({@JoinColumn (name = "firstName"),
                @JoinColumn (name = "lastName")})
    private Medicalrecord medicalrecord;

    public String toString(){
        return "firstname:" + this.firstName + ", lastName:" + this.lastName + ", address:" + this.address + ", city:" + this.city + ", email:" + this.email + ", zip:" + this.zip + ", phone:" + this.phone;
    }


}
