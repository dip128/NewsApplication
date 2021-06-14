package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long agency_id;
	private String agency_name;
	private String agency_logo_path;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "agency_feed_id")
	
	
//	private List<Agency> agency_id;
	
//	@OneToMany(mappedBy = "agency_id")
//	private List<AgencyFeed> agencyfeed;
	

	public long getAgency_id() {
		return agency_id;
	}

	public void setAgency_id(long agency_id) {
		this.agency_id = agency_id;
	}

	public String getAgency_name() {
		return agency_name;
	}

	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}

	public String getAgency_logo_path() {
		return agency_logo_path;
	}

	public void setAgency_logo_path(String agency_logo_path) {
		this.agency_logo_path = agency_logo_path;
	}

	@Override
	public String toString() {
		return "Agency [agency_id=" + agency_id + ", agency_name=" + agency_name + ", agency_logo_path="
				+ agency_logo_path + "]";
	}

}
