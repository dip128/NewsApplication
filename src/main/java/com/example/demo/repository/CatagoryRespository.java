package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CatagoryEntity;

@Repository
public interface CatagoryRespository extends JpaRepository<CatagoryEntity, Long> {
	
	List<CatagoryEntity> findAll();
}
