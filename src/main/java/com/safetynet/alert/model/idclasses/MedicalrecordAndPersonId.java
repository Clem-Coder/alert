package com.safetynet.alert.model.idclasses;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MedicalrecordAndPersonId implements Serializable {
    private String firstName;
    private String lastName;
}
