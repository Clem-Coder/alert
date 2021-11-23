package com.safetynet.alert.model.alerts.communityEmailAlert;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CommunityEmailAlert {

    private List<String> emails = new ArrayList<>();

    public String toString(){
        return " emails:" + this.emails;
    }
}
