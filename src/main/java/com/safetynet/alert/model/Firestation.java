package com.safetynet.alert.model;

import com.safetynet.alert.model.idclasses.FirestationId;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter()
@NoArgsConstructor
@Entity @IdClass(FirestationId.class)
public class Firestation {

    @Id
    private String address;

    private int station;

    @Setter(AccessLevel.NONE)
    @OneToMany (mappedBy = "address")
    List<Person> persons = new ArrayList<>();

    public String toString(){
        return " address:" + this.address + ", station_number:" + this.station;
    }

}
