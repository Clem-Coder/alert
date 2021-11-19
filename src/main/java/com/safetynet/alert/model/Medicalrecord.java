package com.safetynet.alert.model;

import com.safetynet.alert.model.idclasses.MedicalrecordAndPersonId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity @IdClass(MedicalrecordAndPersonId.class)
public class Medicalrecord implements Serializable {
    @Id
    private String firstName;
    @Id
    private String lastName;

    private String birthdate;

    @ElementCollection
    private List<String> medications;

    @ElementCollection
    private List<String> allergies;


}
