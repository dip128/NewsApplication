package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AgencyFeed;

@Repository
public interface AgencyFeedRepository extends JpaRepository<AgencyFeed, Long>{
	
	@Query(value = "SELECT agency_feed_url FROM agency_feed a WHERE a.catagory_id=:catagory_id and a.agency_id=:agency_id", nativeQuery = true)
	String findByCatagoryIDandAgencyId(Long catagory_id, Long agency_id);
}
