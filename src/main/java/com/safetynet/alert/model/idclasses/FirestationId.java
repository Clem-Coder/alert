package com.safetynet.alert.model.idclasses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class FirestationId implements Serializable {
    
    private String address;

}
