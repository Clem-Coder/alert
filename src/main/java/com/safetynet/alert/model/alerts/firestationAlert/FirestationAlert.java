package com.safetynet.alert.model.alerts.firestationAlert;

import lombok.Data;

import java.util.List;

@Data
public class FirestationAlert {

    private int number_of_childs;
    private int number_of_adults;
    private List<FirestationAlertModel> persons_list;
}
