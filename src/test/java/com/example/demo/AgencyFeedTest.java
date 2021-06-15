package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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

import com.example.demo.controller.AgencyFeedController;
import com.example.demo.controller.CatagoryController;

@AutoConfigureMockMvc
@SpringBootTest
class AgencyFeedTest {

	@Autowired
	private CatagoryController cat_cont;

	@Autowired
	private AgencyFeedController cont;

	@Autowired
	MockMvc mvc;

	@Test
	void test() {
		assertNotNull(cont);

	}
	
	@Test
	public void test3GetCatagoryNegativeCase() throws Exception {

		ResultActions actions = mvc
				.perform(MockMvcRequestBuilders.get("http://localhost:8080/news/get?catagory_id=5&agency_id=5"));
		actions.andExpect(status().isNotFound());
	}

	@Test
	public void test4GPostCatagoryNegativeCase() throws Exception {

		ResultActions actions2 = mvc.perform(post(
				"http://localhost:8080/news/add/agencyfeed?catagory_id=5&agency_id=8&feed_url=https://www.hindustantimes.com/feeds/rss/science/rssfeed.xml"));
		actions2.andExpect(status().isNotFound());
	}

	@Test
	public void test1GetCatagoryPositiveCase() throws Exception {

		ResultActions action1 = mvc.perform(post("http://localhost:8080/news/add/catagory/Business"));

		ResultActions action2 = mvc.perform(post("http://localhost:8080/news/add/agency/timesnow").param("logo",
				"https://bestmediainfo.com/wp-content/uploads/2020/02/TIMES-NOW-New-logo_8.jpg"));

		ResultActions actions3 = mvc.perform(post(
				"http://localhost:8080/news/add/agencyfeed?catagory_id=1&agency_id=1&feed_url=https://www.hindustantimes.com/feeds/rss/science/rssfeed.xml"));

		ResultActions actions = mvc
				.perform(MockMvcRequestBuilders.get("http://localhost:8080/news/get?catagory_id=1&agency_id=1"));
		actions.andExpect(status().isOk());
		
	}
	
	@Test
	public void test2PostCatagoryPositiveCase() throws Exception {

		ResultActions action1 = mvc.perform(post("http://localhost:8080/news/add/catagory/Science"));

		ResultActions action2 = mvc.perform(post("http://localhost:8080/news/add/agency/timesnow").param("logo",
				"https://bestmediainfo.com/wp-content/uploads/2020/02/TIMES-NOW-New-logo_8.jpg"));

		ResultActions actions = mvc.perform(post(
				"http://localhost:8080/news/add/agencyfeed?catagory_id=1&agency_id=1&feed_url=https://www.hindustantimes.com/feeds/rss/science/rssfeed.xml"));

		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$.agency_feed_d").exists());
		actions.andExpect(jsonPath("$.agency_feed_d").value(1));
		actions.andExpect(jsonPath("$.agency_feed_url").value("https://www.hindustantimes.com/feeds/rss/science/rssfeed.xml"));
		actions.andExpect(jsonPath("$.agency_id")
				.value(1));
		actions.andExpect(jsonPath("$.catagory_id")
				.value(1));
	}

	
}
