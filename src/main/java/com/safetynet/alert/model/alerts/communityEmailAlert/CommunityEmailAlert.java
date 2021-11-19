package com.safetynet.alert.model.alerts.communityEmailAlert;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommunityEmailAlert {

    private List<String> emails = new ArrayList<>();
}
