package com.safetynet.alert.model.alerts.floodAlert;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FloodAlert {
    List<Integer> station_numbers = new ArrayList<>();
    List<FloodAlertModel> persons_list = new ArrayList<>();
}
