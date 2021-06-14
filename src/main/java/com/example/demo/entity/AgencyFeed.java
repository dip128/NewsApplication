
package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AgencyFeed{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long agency_feed_d;
	private String agency_feed_url;
	private long agency_id;
	private long catagory_id;
	
//	@OneToMany(mappedBy = "agencyfeed")
//	private List<Agency> agency_id;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "agency_id")
//	private long agency_id;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "catagory_id")
//	private long catagory_id;
	
	
	

	public AgencyFeed() {
		super();
	}

	public long getAgency_feed_d() {
		return agency_feed_d;
	}

	public void setAgency_feed_d(long agency_feed_d) {
		this.agency_feed_d = agency_feed_d;
	}

	public String getAgency_feed_url() {
		return agency_feed_url;
	}

	public void setAgency_feed_url(String agency_feed_url) {
		this.agency_feed_url = agency_feed_url;
	}

	public long getAgency_id() {
		return agency_id;
	}

	public void setAgency_id(long agency_id) {
		this.agency_id = agency_id;
	}

	public long getCatagory_id() {
		return catagory_id;
	}

	public void setCatagory_id(long catagory_id) {
		this.catagory_id = catagory_id;
	}

	@Override
	public String toString() {
		return "AgencyFeed [agency_feed_d=" + agency_feed_d + ", agency_feed_url=" + agency_feed_url + ", agency_id="
				+ agency_id + ", catagory_id=" + catagory_id + "]";
	}

	
	
	
	

	

	
	
	
	
}