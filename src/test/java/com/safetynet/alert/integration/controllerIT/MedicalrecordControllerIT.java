package com.safetynet.alert.integration.controllerIT;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MedicalrecordControllerIT {

    @Autowired
    MockMvc mockMvc;

    //RequestMethod.GET

    @Test
    public void testGetMedicalrecords() throws Exception {
        mockMvc.perform(get("/medicalRecords")).andExpect(status().isOk()).andExpect(jsonPath("$[0].birthdate", Matchers.is("03/06/1984")));
    }

    //RequestMethod.POST

    @Test
    public void testAddMedicalRecord() throws Exception {
        mockMvc.perform(post("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Test\", \"lastName\":\"Test\"}")).andExpect(status().isOk());
    }

    @Test
    public void testAddMedicalRecords() throws Exception {
        mockMvc.perform(post("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Test\", \"lastName\":\"Test\"}")).andExpect(status().isOk());
    }

    //RequestMethod.PUT

    @Test
    public void testUpdateMedicalRecord() throws Exception {
        mockMvc.perform(put("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Test\", \"lastName\":\"Test\"}")).andExpect(status().isOk());
    }

    //RequestMethod.DELETE

    @Test
    public void testDeleteMedicalRecord() throws Exception {
        mockMvc.perform(delete("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Reginold\", \"lastName\":\"Walker\"}")).andExpect(status().isOk());
    }


}
