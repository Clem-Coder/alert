package com.safetynet.alert.model.alerts.fireAlert;

import ch.qos.logback.core.util.COWArrayList;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FireAlert {
    private String address;
    private int station_number;
    private List<FireAlertModel> persons_list = new ArrayList<>();

    public String toString(){
        return " address:" + this.address + ", station_number:" + this.station_number + ", persons_list:" + this.persons_list ;
    }

}
