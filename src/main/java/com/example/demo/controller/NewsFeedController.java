package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Agency;
import com.example.demo.entity.CatagoryEntity;
import com.example.demo.entity.NewsEntity;
import com.example.demo.exception.WrongInputCombination;
import com.example.demo.repository.AgencyRepository;
import com.example.demo.repository.CatagoryRespository;
import com.example.demo.repository.NewsFeedRepository;

@RestController
public class NewsFeedController {
	
	@Autowired
	private NewsFeedRepository newsRepo;
	
	@Autowired
	private CatagoryRespository catrepo;
	
	@Autowired
	private AgencyRepository agencyrepo;

	@PostMapping("news/add/post/")
	public NewsEntity getNewsAll(@RequestParam("catagory_id") long cat_id,@RequestParam("agency_id") long agency_id,@RequestParam("news_date") Date news_date,
							@RequestParam("news_desc") String news_desc,@RequestParam("news_title") String news_title,@RequestParam("news_link") String news_link) throws WrongInputCombination {
		
		Optional<CatagoryEntity> cat = Optional.ofNullable(catrepo.findById(cat_id).orElseThrow(WrongInputCombination::new));
		Optional<Agency> agency=Optional.ofNullable(agencyrepo.findById(agency_id).orElseThrow(WrongInputCombination::new));
		
		
		NewsEntity newsEntity = new NewsEntity();
		newsEntity.setAgency_id(agency_id);
		newsEntity.setCatagory_id(cat_id);
		newsEntity.setClick_count(0);
		newsEntity.setNews_date(news_date);
		newsEntity.setNews_desc(news_desc);
		newsEntity.setNews_link(news_link);
		newsEntity.setNews_title(news_title);
		NewsEntity save = newsRepo.save(newsEntity);
		return save;
		
	}
	
	@PutMapping("news/add/update/click/count")
	public void updateClick(@RequestParam("news_id") long news_id,@RequestParam("click_count") int click_count) throws WrongInputCombination {
		
		Optional.ofNullable(newsRepo.findById(news_id).orElseThrow(WrongInputCombination::new));
		newsRepo.updateCount(news_id, click_count);
		
	}
	
	@DeleteMapping("news/delete/all")
	public void deleteAllNews() {
		newsRepo.deleteAll();
	}
	
	@GetMapping("/get/news/{catagory_id}/{agency_id}")
	public List<NewsEntity> getNewsByCatagoryandAgency(@PathVariable long agency_id,@PathVariable long catagory_id) {
		
		
//		 Optional.ofNullable(((Optional<CatagoryEntity>) newsRepo.findByCatagoryIDandAgencyId(catagory_id, agency_id)).orElseThrow(WrongInputCombination::new));
		 List<NewsEntity> list = newsRepo.findByCatagoryIDandAgencyId(catagory_id, agency_id);
		
		 if(list.size()==0) return new ArrayList<>();
		 
		 return list;
	}
	

}
