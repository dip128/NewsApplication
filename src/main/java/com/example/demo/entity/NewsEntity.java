package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NewsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long news_id;
	private String news_title;
	private String news_desc;
	private Date news_date;
	private String news_link;
	private int click_count;
	private long catagory_id;
	private long agency_id;
	
	
	public NewsEntity() {
		super();
	}
	
	public long getNews_id() {
		return news_id;
	}
	public void setNews_id(long news_id) {
		this.news_id = news_id;
	}
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	public String getNews_desc() {
		return news_desc;
	}
	public void setNews_desc(String news_desc) {
		this.news_desc = news_desc;
	}
	public Date getNews_date() {
		return news_date;
	}
	public void setNews_date(Date news_date) {
		this.news_date = news_date;
	}
	public String getNews_link() {
		return news_link;
	}
	public void setNews_link(String news_link) {
		this.news_link = news_link;
	}
	public int getClick_count() {
		return click_count;
	}
	public void setClick_count(int click_count) {
		this.click_count = click_count;
	}
	public long getCatagory_id() {
		return catagory_id;
	}
	public void setCatagory_id(long catagory_id) {
		this.catagory_id = catagory_id;
	}
	public long getAgency_id() {
		return agency_id;
	}
	public void setAgency_id(long agency_id) {
		this.agency_id = agency_id;
	}
	@Override
	public String toString() {
		return "NewsEntity [news_id=" + news_id + ", news_title=" + news_title + ", news_desc=" + news_desc
				+ ", news_date=" + news_date + ", news_link=" + news_link + ", click_count=" + click_count
				+ ", catagory_id=" + catagory_id + ", agency_id=" + agency_id + "]";
	}
	
	

}
