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

import com.example.demo.controller.CatagoryController;
import com.example.demo.controller.NewsFeedController;

@AutoConfigureMockMvc
@SpringBootTest
class NewsFeedControllerTest {

	@Autowired
	private CatagoryController cat_cont;

	@Autowired
	private NewsFeedController cont;

	@Autowired
	MockMvc mvc;

	@Test
	void test() {
		assertNotNull(cont);
	}

	@Test
	public void test1PostCatagoryPositiveCase() throws Exception {

		ResultActions action1 = mvc.perform(post("http://localhost:8080/news/add/catagory/Science"));

		ResultActions action2 = mvc.perform(post("http://localhost:8080/news/add/agency/timesnow").param("logo",
				"https://bestmediainfo.com/wp-content/uploads/2020/02/TIMES-NOW-New-logo_8.jpg"));

		ResultActions actions = mvc.perform(MockMvcRequestBuilders.post(
				"http://localhost:8080/news/add/post/?catagory_id=1&agency_id=1&news_date=11/06/2021&news_desc=The probe also sent back a video taken by a camera on the orbiter, showing how the Tianwen-1 lander and the Zhurong rover separated from the orbiter while landing on the surface of Mars.&news_title=China's Mars rover sends back images to Earth&news_link=https://www.hindustantimes.com/world-news/chinas-mars-rover-sends-back-images-to-earth-101623431813858.html"));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$.news_id").exists());
		actions.andExpect(jsonPath("$.news_id").value(2));
		actions.andExpect(jsonPath("$.news_title").value("China's Mars rover sends back images to Earth"));
		actions.andExpect(jsonPath("$.news_desc").value(
				"The probe also sent back a video taken by a camera on the orbiter, showing how the Tianwen-1 lander and the Zhurong rover separated from the orbiter while landing on the surface of Mars."));
		actions.andExpect(jsonPath("$.news_date").value("2021-11-05T18:30:00.000+00:00"));
		actions.andExpect(jsonPath("$.news_link").value(
				"https://www.hindustantimes.com/world-news/chinas-mars-rover-sends-back-images-to-earth-101623431813858.html"));
		actions.andExpect(jsonPath("$.click_count").value(0));
		actions.andExpect(jsonPath("$.catagory_id").value(1));
		actions.andExpect(jsonPath("$.agency_id").value(1));
	}

	@Test
	public void test2PostCatagoryNegativeCase() throws Exception {

		ResultActions actions = mvc.perform(MockMvcRequestBuilders.post(
				"http://localhost:8080/post/news?catagory_id=10&agency_id=11&news_date=11/06/2021&news_desc=The probe also sent back a video taken by a camera on the orbiter, showing how the Tianwen-1 lander and the Zhurong rover separated from the orbiter while landing on the surface of Mars.&news_title=China's Mars rover sends back images to Earth&news_link=https://www.hindustantimes.com/world-news/chinas-mars-rover-sends-back-images-to-earth-101623431813858.html"));
		actions.andExpect(status().isNotFound());
	}

	@Test
	public void test3PutCatagoryNegativeCase() throws Exception {

		ResultActions action1 = mvc.perform(post("http://localhost:8080/news/add/catagory/Business"));

		ResultActions action2 = mvc.perform(post("http://localhost:8080/news/add/agency/timesnow").param("logo",
				"https://bestmediainfo.com/wp-content/uploads/2020/02/TIMES-NOW-New-logo_8.jpg"));

		ResultActions actions3 = mvc.perform(MockMvcRequestBuilders.post(
				"http://localhost:8080/news/add/post/?catagory_id=1&agency_id=1&news_date=11/06/2021&news_desc=The probe also sent back a video taken by a camera on the orbiter, showing how the Tianwen-1 lander and the Zhurong rover separated from the orbiter while landing on the surface of Mars.&news_title=China's Mars rover sends back images to Earth&news_link=https://www.hindustantimes.com/world-news/chinas-mars-rover-sends-back-images-to-earth-101623431813858.html"));

		ResultActions actions = mvc.perform(MockMvcRequestBuilders
				.put("http://localhost:8080/news/add/update/click/count?news_id=5&click_count=2"));
		actions.andExpect(status().isNotFound());
	}

	@Test
	public void test4DeleteCatagoryPositiveCase() throws Exception {

		ResultActions action1 = mvc.perform(post("http://localhost:8080/news/add/catagory/Business"));

		ResultActions action2 = mvc.perform(post("http://localhost:8080/news/add/agency/timesnow").param("logo",
				"https://bestmediainfo.com/wp-content/uploads/2020/02/TIMES-NOW-New-logo_8.jpg"));

		ResultActions actions3 = mvc.perform(MockMvcRequestBuilders.post(
				"http://localhost:8080/news/add/post/?catagory_id=1&agency_id=1&news_date=11/06/2021&news_desc=The probe also sent back a video taken by a camera on the orbiter, showing how the Tianwen-1 lander and the Zhurong rover separated from the orbiter while landing on the surface of Mars.&news_title=China's Mars rover sends back images to Earth&news_link=https://www.hindustantimes.com/world-news/chinas-mars-rover-sends-back-images-to-earth-101623431813858.html"));

		ResultActions actions = mvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/news/delete/all"));
		actions.andExpect(status().isOk());
	}

}
