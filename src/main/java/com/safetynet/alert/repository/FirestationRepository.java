package com.safetynet.alert.repository;

import com.safetynet.alert.model.Firestation;
import com.safetynet.alert.model.idclasses.FirestationId;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface FirestationRepository extends CrudRepository <Firestation, FirestationId> {

    Iterable<Firestation> findAllByOrderByStationAsc();

    Iterable<Firestation> findByStation(int station);

    Iterable<Firestation> findByAddress(String address);


}
