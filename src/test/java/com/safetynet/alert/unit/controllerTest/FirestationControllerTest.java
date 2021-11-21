package com.safetynet.alert.unit.controllerTest;

import com.safetynet.alert.controller.FirestationController;
import com.safetynet.alert.service.FirestationService;
import com.safetynet.alert.service.PersonService;
import com.safetynet.alert.service.PersonsSortingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FirestationController.class)
public class FirestationControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PersonService personService;

    @MockBean
    FirestationService firestationService;

    @MockBean
    PersonsSortingService personsSortingService;

    //RequestMethod.GET

    @Test
    public void testGetFirestations() throws Exception {
        mockMvc.perform(get("/firestations")).andExpect(status().isOk());
    }

    @Test
    public void testGetFirestationAlertByStationNumber() throws Exception {
        mockMvc.perform(get("/firestation").param("stationNumber", "1")).andExpect(status().isOk());
    }

    //RequestMethod.POST

    @Test
    public void testAddFirestation() throws Exception {
        mockMvc.perform(post("/firestation").contentType(MediaType.APPLICATION_JSON).content("{\"address\": \"Test\", \"station\":\"1\"}")).andExpect(status().isOk());
    }

    //RequestMethod.PUT

    @Test
    public void testUpdateFirestation() throws Exception {
        mockMvc.perform(put("/firestation").contentType(MediaType.APPLICATION_JSON).content("{\"address\": \"Test\", \"station\":\"1\"}")).andExpect(status().isOk());
    }

    //RequestMethod.DELETE

    @Test
    public void testDeleteFirestation() throws Exception {
        mockMvc.perform(delete("/firestation").contentType(MediaType.APPLICATION_JSON).content("{\"address\": \"Test\", \"station\":\"1\"}")).andExpect(status().isOk());
    }

}
