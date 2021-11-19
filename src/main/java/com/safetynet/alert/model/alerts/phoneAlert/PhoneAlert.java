package com.safetynet.alert.model.alerts.phoneAlert;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PhoneAlert {
    List<String> phones_list = new ArrayList<>();
}
