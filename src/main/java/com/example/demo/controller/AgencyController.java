package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Agency;
import com.example.demo.repository.AgencyRepository;

@RestController
public class AgencyController {
	
	@Autowired
	private AgencyRepository repo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AgencyController.class);
	
	@GetMapping("/news/agency/all")
	public List<Agency> getAllAgency(){
		List<Agency> list = repo.findAll();
		
		if(list.size()==0) return new ArrayList<Agency>();
		
		return list;
	}
	
	@PostMapping("/news/add/agency/{name}")
	public Agency addAgency(@PathVariable String name,@RequestParam("logo") String logo) {
		
		Agency agency = new Agency();
		agency.setAgency_name(name);
		agency.setAgency_logo_path(logo);
		
		Agency save = repo.save(agency);
		
		return save;
	}

}
