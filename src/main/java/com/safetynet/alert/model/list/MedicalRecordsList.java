package com.safetynet.alert.model.list;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.safetynet.alert.model.Medicalrecord;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicalRecordsList {

    private List<Medicalrecord> medicalrecords = new ArrayList<Medicalrecord>();

    public MedicalRecordsList() {
        this.medicalrecords = new ArrayList<Medicalrecord>();
    }

    public List<Medicalrecord> getMedicalrecords() {
        return medicalrecords;
    }

    public void setMedicalRecordsList(List<Medicalrecord> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }
}
