package com.safetynet.alert.unit.controllerTest;

import com.safetynet.alert.controller.FirestationController;
import com.safetynet.alert.controller.MedicalrecordController;
import com.safetynet.alert.model.Medicalrecord;
import com.safetynet.alert.service.FirestationService;
import com.safetynet.alert.service.MedicalrecordService;
import com.safetynet.alert.service.PersonService;
import com.safetynet.alert.service.PersonsSortingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MedicalrecordController.class)
public class MedicalrecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MedicalrecordService medicalrecordService;

    //RequestMethod.GET

    @Test
    public void testGetMedicalrecords() throws Exception {
        mockMvc.perform(get("/medicalRecords")).andExpect(status().isOk());
    }

    //RequestMethod.POST

    @Test
    public void testAddMedicalRecord() throws Exception {
        mockMvc.perform(post("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Test\", \"lastName\":\"Test\"}")).andExpect(status().isOk());
    }

//    @Test
//    public void testAddMedicalRecords() throws Exception {
//        Medicalrecord medicalrecord1 = new Medicalrecord();
//
//        mockMvc.perform(post("/medicalRecords").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Test\", \"lastName\":\"Test\"}")).andExpect(status().isOk());
//    }

    //RequestMethod.PUT

    @Test
    public void testUpdateMedicalRecord() throws Exception {
        mockMvc.perform(put("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Test\", \"lastName\":\"Test\"}")).andExpect(status().isOk());
    }

    //RequestMethod.DELETE

    @Test
    public void testDeleteMedicalRecord() throws Exception {
        mockMvc.perform(delete("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Test\", \"lastName\":\"Test\"}")).andExpect(status().isOk());
    }
}
