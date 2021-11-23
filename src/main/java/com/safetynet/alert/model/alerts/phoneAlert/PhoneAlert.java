package com.safetynet.alert.model.alerts.phoneAlert;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PhoneAlert {
    List<String> phones_list = new ArrayList<>();

    public String toString(){
        return " phones_list:" + this.phones_list ;
    }
}
