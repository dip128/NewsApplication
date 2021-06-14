package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.NewsEntity;

public interface NewsFeedRepository extends JpaRepository<NewsEntity, Long>{
	
	@Query(value ="SELECT * FROM news_entity a WHERE a.catagory_id=:catagory_id and a.agency_id=:agency_id", nativeQuery = true)
	List<NewsEntity> findByCatagoryIDandAgencyId(long catagory_id,long agency_id);

	@Transactional
	@Modifying
	@Query("update NewsEntity n SET n.click_count=:click_count WHERE n.news_id=:news_id")
	void updateCount(long news_id, int click_count);
	
}
