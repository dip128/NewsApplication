package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.controller.AgencyController;

@AutoConfigureMockMvc
@SpringBootTest
class AgencyTest {

	@Autowired
	private AgencyController cont;

	@Autowired
	MockMvc mvc;

	@Test
	void test() {
		assertNotNull(cont);
	}

	@Test
	public void test2GetCatagory() throws Exception {

		ResultActions action = mvc.perform(post("http://localhost:8080/news/add/agency/timesnow").param("logo",
				"https://bestmediainfo.com/wp-content/uploads/2020/02/TIMES-NOW-New-logo_8.jpg"));
		
		ResultActions actions = mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/news/agency/all"));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$[0].agency_id").exists());
		actions.andExpect(jsonPath("$[0].agency_id").value(1));
		actions.andExpect(jsonPath("$[0].agency_name").value("timesnow"));
		actions.andExpect(jsonPath("$[0].agency_logo_path").value("https://bestmediainfo.com/wp-content/uploads/2020/02/TIMES-NOW-New-logo_8.jpg"));
	}

	@Test
	public void test1PostCatagory() throws Exception {

		ResultActions actions = mvc.perform(post("http://localhost:8080/news/add/agency/timesnow").param("logo",
				"https://bestmediainfo.com/wp-content/uploads/2020/02/TIMES-NOW-New-logo_8.jpg"));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$.agency_id").exists());
		actions.andExpect(jsonPath("$.agency_id").value(2));
		actions.andExpect(jsonPath("$.agency_name").value("timesnow"));
		actions.andExpect(jsonPath("$.agency_logo_path")
				.value("https://bestmediainfo.com/wp-content/uploads/2020/02/TIMES-NOW-New-logo_8.jpg"));
		// actions.andExpect(jsonPath("$.agency_name").value("timesnow"));
	}

}
