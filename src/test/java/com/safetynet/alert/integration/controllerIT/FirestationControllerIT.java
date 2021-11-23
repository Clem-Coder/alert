package com.safetynet.alert.integration.controllerIT;

import com.safetynet.alert.controller.FirestationController;
import com.safetynet.alert.service.FirestationService;
import com.safetynet.alert.service.PersonService;
import com.safetynet.alert.service.PersonsSortingService;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FirestationControllerIT {

    @Autowired
    private MockMvc mockMvc;

    //RequestMethod.GET

    @Test
    public void getFirestations() throws Exception {
        mockMvc.perform(get("/firestations")).andExpect(status().isOk()).andExpect(jsonPath("$[1].address", Matchers.is("947 E. Rose Dr")));
    }

    @Test
    public void getFirestationAlertByStationNumber() throws Exception {
        mockMvc.perform(get("/firestation").param("stationNumber", "3")).andExpect(status().isOk()).andExpect(jsonPath("number_of_childs", Matchers.is(3)));
    }

    //RequestMethod.POST

    @Test
    public void addFirestation() throws Exception {
        mockMvc.perform(post("/firestation").contentType(MediaType.APPLICATION_JSON).content("{\"address\": \"Test\", \"station\":\"1\"}")).andExpect(status().isOk());
    }

    //RequestMethod.PUT

    @Test
    public void testUpdateFirestation() throws Exception {
        mockMvc.perform(put("/firestation").contentType(MediaType.APPLICATION_JSON).content("{\"address\": \"Test\", \"station\":\"1\"}")).andExpect(status().isOk());
    }

    //RequestMethod.DELETE

    @Test
    public void deleteFirestation() throws Exception {
        mockMvc.perform(delete("/firestation").content("29 15th St")).andExpect(status().isOk());
    }

}
