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

import com.example.demo.controller.CatagoryController;

@AutoConfigureMockMvc
@SpringBootTest
class CatagoryTest {
	
	@Autowired
	private CatagoryController cont;
	
	@Autowired
	MockMvc mvc;

	@Test
	void test() {
		assertNotNull(cont);
	}
	
	@Test
	public void test2GetCatagory() throws Exception {
		
		ResultActions action=mvc.perform(post("http://localhost:8080/news/add/catagory/Business"));
		
		ResultActions actions=mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/news/catagories/all"));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$[0].catagory_id").exists());
		actions.andExpect(jsonPath("$[0].catagory_id").value(1));
		actions.andExpect(jsonPath("$[0].catagory_title").value("Business"));
	}
	
	
	
	@Test
	public void test1PostCatagory() throws Exception {
		
		ResultActions actions=mvc.perform(post("http://localhost:8080/news/add/catagory/Science"));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$.catagory_id").exists());
		actions.andExpect(jsonPath("$.catagory_id").value(2));
		actions.andExpect(jsonPath("$.catagory_title").value("Science"));
	}
	
	
	

}
