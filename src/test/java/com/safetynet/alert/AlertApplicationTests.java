package com.safetynet.alert;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AlertApplicationTests {

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
		mockMvc.perform(get("/phoneAlert").param("firestation","1")).andExpect(status().isOk()).andExpect(jsonPath("phones_list[0]", Matchers.is("841-874-8547")));
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

	@Test
	public void getFloodAlertByStationNumberIT() throws Exception {
		mockMvc.perform(get("/flood/stations").param("stations","2")).andExpect(status().isOk()).andExpect(jsonPath("persons_list[1].firstName", Matchers.is("Sophia")));
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

	@Test
	public void testGetMedicalrecords() throws Exception {
		mockMvc.perform(get("/medicalRecords")).andExpect(status().isOk()).andExpect(jsonPath("$[0].birthdate", Matchers.is("03/06/1989")));
	}

	//RequestMethod.POST

	@Test
	public void testAddMedicalRecord() throws Exception {
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
		mockMvc.perform(delete("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"John\", \"lastName\":\"Boyd\"}")).andExpect(status().isOk());
	}

	@Test
	public void testGetFirestations() throws Exception {
		mockMvc.perform(get("/firestations")).andExpect(status().isOk()).andExpect(jsonPath("$[1].address", Matchers.is("947 E. Rose Dr")));
	}

	@Test
	public void testGetFirestationAlertByStationNumber() throws Exception {
		mockMvc.perform(get("/firestation").param("stationNumber", "1")).andExpect(status().isOk()).andExpect(jsonPath("number_of_childs", Matchers.is(1)));
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
		mockMvc.perform(delete("/firestation").content("644 Gershwin Cir")).andExpect(status().isOk());
	}

}
