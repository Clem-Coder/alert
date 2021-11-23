package com.safetynet.alert.model.alerts.floodAlert;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FloodAlert {
    List<Integer> station_numbers = new ArrayList<>();
    List<FloodAlertModel> persons_list = new ArrayList<>();

    public String toString(){
        return " station_numbers:" + this.station_numbers + ", persons_list:" + this.persons_list ;
    }
}
