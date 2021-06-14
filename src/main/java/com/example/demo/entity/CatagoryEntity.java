package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CatagoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long catagory_id;
	private String catagory_title;

//	@OneToMany(mappedBy = "catagory_id")
//	private List<AgencyFeed> agencyfeed;
	
	public long getCatagory_id() {
		return catagory_id;
	}

	public void setCatagory_id(long catagory_id) {
		this.catagory_id = catagory_id;
	}

	public String getCatagory_title() {
		return catagory_title;
	}

	public void setCatagory_title(String catagory_title) {
		this.catagory_title = catagory_title;
	}

	@Override
	public String toString() {
		return "CatagoryEntity [catagory_id=" + catagory_id + ", catagory_title=" + catagory_title + "]";
	}

}
