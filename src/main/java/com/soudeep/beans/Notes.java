package com.soudeep.beans;

import java.io.Serializable;
import java.util.Date;

public class Notes implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private String content;
	private Date date;
	private Integer uId;


	public Notes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notes(Integer id, String title, String content, Date date, Integer uId) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
		this.uId = uId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	
}
