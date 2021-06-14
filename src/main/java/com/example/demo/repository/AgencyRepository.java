package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Agency;

public interface AgencyRepository extends JpaRepository<Agency, Long>{

}
