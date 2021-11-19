package com.safetynet.alert.model.idclasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MedicalrecordAndPersonId implements Serializable {
    private String firstName;
    private String lastName;
}
