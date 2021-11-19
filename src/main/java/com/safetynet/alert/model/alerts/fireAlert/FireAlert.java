package com.safetynet.alert.model.alerts.fireAlert;

import ch.qos.logback.core.util.COWArrayList;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FireAlert {
    private String address;
    private int station_number;
    private List<FireAlertModel> persons_list = new ArrayList<>();

}
