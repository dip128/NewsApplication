package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CatagoryEntity;
import com.example.demo.repository.CatagoryRespository;

@RestController
public class CatagoryController {
	
	@Autowired
	private CatagoryRespository repo;
	
	@GetMapping("news/catagories/all")
	public List<CatagoryEntity> getAllCatagories(){
		
		List<CatagoryEntity> list = repo.findAll();
		
		if(list==null) return new ArrayList<CatagoryEntity>();
		return list;
	}
	
	@PostMapping("news/add/catagory/{name}")
	public CatagoryEntity addCatagory(@PathVariable String name) {
		
		CatagoryEntity catagoryEntity = new CatagoryEntity();
		
		catagoryEntity.setCatagory_title(name);
		
		repo.save(catagoryEntity);
		
		return catagoryEntity;
		
	}
}
