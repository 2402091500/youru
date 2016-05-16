package com.example.entity;

import java.sql.Date;

public class Msg {
	/*"_id","date","message_count","snippet"*/
	private String name;
	private String date;
	private  int message_count;
	private  int unread_count;
	private String snippet;
	
	
	
	public Msg() {
	}



	public Msg(String name, String date, int message_count, int unread_count,
			String snippet) {
		super();
		this.name = name;
		this.date = date;
		this.message_count = message_count;
		this.unread_count = unread_count;
		this.snippet = snippet;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public int getMessage_count() {
		return message_count;
	}



	public void setMessage_count(int message_count) {
		this.message_count = message_count;
	}



	public int getUnread_count() {
		return unread_count;
	}



	public void setUnread_count(int unread_count) {
		this.unread_count = unread_count;
	}



	public String getSnippet() {
		return snippet;
	}



	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}



	

	
	
}
