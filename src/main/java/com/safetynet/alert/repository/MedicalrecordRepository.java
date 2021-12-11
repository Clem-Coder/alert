package com.safetynet.alert.repository;

import com.safetynet.alert.model.Medicalrecord;
import com.safetynet.alert.model.idclasses.MedicalrecordAndPersonId;
import org.springframework.data.repository.CrudRepository;

public interface MedicalrecordRepository extends CrudRepository<Medicalrecord, MedicalrecordAndPersonId> {
    /**
     * here are all the methods used to access and manipulate datas in medicalrecord table
     */
}
