package com.safetynet.alert.unit.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.safetynet.alert.controller.PersonController;
import com.safetynet.alert.service.FirestationService;
import com.safetynet.alert.service.PersonService;
import com.safetynet.alert.service.PersonsSortingService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = PersonController.class)
public class PersonsControllerTest {

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
    public void testGetPersons() throws Exception {
        mockMvc.perform(get("/persons")).andExpect(status().isOk());
    }

    @Test
    public void testGetChildAlertByAddress() throws Exception {
        mockMvc.perform(get("/childAlert").param("address","1509 Culver St")).andExpect(status().isOk());
    }

    @Test
    public void testGetPhoneAlertByStationNumber() throws Exception {
        mockMvc.perform(get("/phoneAlert").param("firestation","1")).andExpect(status().isOk());
    }

    @Test
    public void testGetFireAlertByStationAddress() throws Exception {
        mockMvc.perform(get("/fire").param("address","1509 Culver St")).andExpect(status().isOk());
    }

    @Test
    public void testGetPersonInfoAlertByFirstNameAndLastName() throws Exception {
        mockMvc.perform(get("/personInfo").param("firstName","John").param("lastName","Boyd")).andExpect(status().isOk());
    }

    @Test
    public void testGetCommunityEmailAlertByStationNumber() throws Exception {
        mockMvc.perform(get("/communityEmail").param("city","Culver")).andExpect(status().isOk());
    }

    @Test
    public void testGetFloodAlertByStationNumber() throws Exception {
        mockMvc.perform(get("/flood/stations").param("stations","2")).andExpect(status().isOk());
    }


    //RequestMethod.POST

    @Test
    public void testAddPerson() throws Exception {
        mockMvc.perform(post("/person").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Test\", \"lastName\":\"Test\"}")).andExpect(status().isOk());
    }

    //RequestMethod.PUT

    @Test
    public void testUptadePerson() throws Exception {
        mockMvc.perform(put("/person").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Test\", \"lastName\":\"Test\"}")).andExpect(status().isOk());
    }

    //RequestMethod.DELETE

    @Test
    public void TestDeletePerson() throws Exception {
        mockMvc.perform(delete("/person").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Test\", \"lastName\":\"Test\"}")).andExpect(status().isOk());
    }

}
