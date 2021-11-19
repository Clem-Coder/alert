package com.safetynet.alert.model;

import com.safetynet.alert.model.idclasses.MedicalrecordAndPersonId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
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

    @OneToOne
    @JoinColumns({@JoinColumn (name = "firstName"),
                @JoinColumn (name = "lastName")})
    private Medicalrecord medicalrecord;



}
