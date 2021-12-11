package com.safetynet.alert.repository;

import com.safetynet.alert.model.Firestation;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface FirestationRepository extends CrudRepository <Firestation, String> {

    /**
     * here are all the methods used to access and manipulate datas in firestation table
     */

    Iterable<Firestation> findAllByOrderByStationAsc();

    Iterable<Firestation> findByStation(int station);

    Iterable<Firestation> findByAddress(String address);
}
