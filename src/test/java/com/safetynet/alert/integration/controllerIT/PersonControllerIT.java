package com.safetynet.alert.integration.controllerIT;

import com.safetynet.alert.service.FirestationService;
import com.safetynet.alert.service.PersonService;
import com.safetynet.alert.service.PersonsSortingService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerIT {

    @Autowired
    private MockMvc mockMvc;

    //RequestMethod.GET

    @Test
    public void getPersonsIT() throws Exception {
        mockMvc.perform(get("/persons")).andExpect(status().isOk()).andExpect(jsonPath("$[1].firstName", Matchers.is("Tenley")));
    }

    @Test
    public void getChildAlertByAddressIT() throws Exception {
        mockMvc.perform(get("/childAlert").param("address","892 Downing Ct")).andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", Matchers.is("Zach")));
    }

    @Test
    public void getPhoneAlertByStationNumberIT() throws Exception {
        mockMvc.perform(get("/phoneAlert").param("firestation","1")).andExpect(status().isOk()).andExpect(jsonPath("phones_list[0]", Matchers.is("841-874-8547")));
    }

    @Test
    public void getFireAlertByStationAddressIT() throws Exception {
        mockMvc.perform(get("/fire").param("address","951 LoneTree Rd")).andExpect(status().isOk()).andExpect(jsonPath("persons_list[0].firstName", Matchers.is("Eric")));
    }

    @Test
    public void getPersonInfoAlertByFirstNameAndLastNameIT() throws Exception {
        mockMvc.perform(get("/personInfo").param("firstName","Jonanathan").param("lastName","Marrack")).andExpect(status().isOk()).andExpect(jsonPath("age", Matchers.is(32)));
    }

    @Test
    public void getCommunityEmailAlertByStationNumberIT() throws Exception {
        mockMvc.perform(get("/communityEmail").param("city","Culver")).andExpect(status().isOk()).andExpect(jsonPath("emails[0]", Matchers.is("drk@email.com")));
    }

    @Test
    public void getFloodAlertByStationNumberIT() throws Exception {
        mockMvc.perform(get("/flood/stations").param("stations","2")).andExpect(status().isOk()).andExpect(jsonPath("persons_list[1].firstName", Matchers.is("Warren")));
    }

    //RequestMethod.POST

    @Test
    public void addPersonIT() throws Exception {
        mockMvc.perform(post("/person").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Test\", \"lastName\":\"Test\"}")).andExpect(status().isOk());
    }

    //RequestMethod.PUT

    @Test
    public void uptadePersonIT() throws Exception {
        mockMvc.perform(put("/person").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Test\", \"lastName\":\"Test\"}")).andExpect(status().isOk());
    }

    //RequestMethod.DELETE

    @Test
    public void deletePersonIT() throws Exception {
        mockMvc.perform(delete("/person").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Sophia\", \"lastName\":\"Zemicks\"}")).andExpect(status().isOk());
    }

}

