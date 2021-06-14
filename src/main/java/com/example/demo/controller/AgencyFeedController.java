package com.example.demo.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Agency;
import com.example.demo.entity.AgencyFeed;
import com.example.demo.entity.CatagoryEntity;
import com.example.demo.exception.WrongInputCombination;
import com.example.demo.repository.AgencyFeedRepository;
import com.example.demo.repository.AgencyRepository;
import com.example.demo.repository.CatagoryRespository;

@RestController
public class AgencyFeedController {
	
	@Autowired
	private AgencyFeedRepository repo;
	
	@Autowired
	private CatagoryRespository catrepo;
	
	@Autowired
	private AgencyRepository agencyrepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AgencyFeedController.class);
	
	@PostMapping("/news/add/agencyfeed")
	public AgencyFeed addAgencyFeed(@RequestParam("catagory_id") long cat_id, @RequestParam("agency_id") long agency_id, @RequestParam("feed_url") String feed_url) throws WrongInputCombination {
		
		AgencyFeed feed = new AgencyFeed();
		
		Optional<CatagoryEntity> cat = Optional.ofNullable(catrepo.findById(cat_id).orElseThrow(WrongInputCombination::new));
		Optional<Agency> agency=Optional.ofNullable(agencyrepo.findById(agency_id).orElseThrow(WrongInputCombination::new));
		
			
		feed.setAgency_id(agency_id);
		feed.setCatagory_id(cat_id);
		feed.setAgency_feed_url(feed_url);
		
		AgencyFeed agencyFeed = repo.save(feed);
		
		return agencyFeed;
		
		
	}
	@GetMapping("/news/get")
	public String getAgencyFeedUrl(@RequestParam("catagory_id") long cat_id, @RequestParam("agency_id") long agency_id) throws WrongInputCombination {
		
		LOGGER.info("Exceturing get AgencyFeed URL");
		Optional<CatagoryEntity> cat = Optional.ofNullable(catrepo.findById(cat_id).orElseThrow(WrongInputCombination::new));
		Optional<Agency> agency=Optional.ofNullable(agencyrepo.findById(agency_id).orElseThrow(WrongInputCombination::new));
		String url = repo.findByCatagoryIDandAgencyId(cat_id, agency_id);
		
		return url;
	}

}
