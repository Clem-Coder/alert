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
    public void GetPersonsIT() throws Exception {
        mockMvc.perform(get("/persons")).andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", Matchers.is("John")));
    }

    @Test
    public void GetChildAlertByAddressIT() throws Exception {
        mockMvc.perform(get("/childAlert").param("address","892 Downing Ct")).andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", Matchers.is("Zach")));
    }

    @Test
    public void GetPhoneAlertByStationNumberIT() throws Exception {
        mockMvc.perform(get("/phoneAlert").param("firestation","1")).andExpect(status().isOk()).andExpect(jsonPath("phones_list[0]", Matchers.is("841-874-6512")));
    }

    @Test
    public void GetFireAlertByStationAddressIT() throws Exception {
        mockMvc.perform(get("/fire").param("address","951 LoneTree Rd")).andExpect(status().isOk()).andExpect(jsonPath("persons_list[0].firstName", Matchers.is("Eric")));
    }

    @Test
    public void GetPersonInfoAlertByFirstNameAndLastNameIT() throws Exception {
        mockMvc.perform(get("/personInfo").param("firstName","Jonanathan").param("lastName","Marrack")).andExpect(status().isOk()).andExpect(jsonPath("age", Matchers.is(32)));
    }

    @Test
    public void GetCommunityEmailAlertByStationNumberIT() throws Exception {
        mockMvc.perform(get("/communityEmail").param("city","Culver")).andExpect(status().isOk()).andExpect(jsonPath("emails[0]", Matchers.is("jaboyd@email.com")));
    }

    //RequestMethod.POST

    @Test
    public void AddPersonIT() throws Exception {
        mockMvc.perform(post("/person").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Test\", \"lastName\":\"Test\"}")).andExpect(status().isOk());
    }

    //RequestMethod.PUT

    @Test
    public void UptadePersonIT() throws Exception {
        mockMvc.perform(put("/person").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Test\", \"lastName\":\"Test\"}")).andExpect(status().isOk());
    }

    //RequestMethod.DELETE

    @Test
    public void DeletePersonIT() throws Exception {
        mockMvc.perform(delete("/person").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"John\", \"lastName\":\"Boyd\"}")).andExpect(status().isOk());
    }

}

