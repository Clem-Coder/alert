package com.safetynet.alert.model.alerts.firestationAlert;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FirestationAlert {

    private int number_of_childs;
    private int number_of_adults;
    private List<FirestationAlertModel> persons_list;

    public String toString(){
        return " number_of_childs:" + this.number_of_childs + ", number_of_adults:" + this.number_of_adults + ", persons_list:" + this.persons_list ;
    }
}
