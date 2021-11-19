package com.safetynet.alert.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Firestation {
    @Id
    private String address;
    private int station;

    @OneToMany (mappedBy = "address")
    List<Person> persons = new ArrayList<>();

}
