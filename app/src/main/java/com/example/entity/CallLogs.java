package com.example.entity;

import java.io.Serializable;

public class CallLogs implements Serializable{

	private int id;
	/*联系人关像id*/
	private int photoId;
	/*联系人姓名*/
	private String name;
	/*联系人电话号码*/
	private String number;
	/*呼叫时间*/
	private long time;
	/*呼叫类型
	INCOMING_TYPE
    OUTGOING_TYPE
    MISSED_TYPE */
	private int type;
	/*通话时长*/
	private  long durations;


	public CallLogs() {
		// TODO Auto-generated constructor stub
	}

	public CallLogs(int id, int photoId, String name, String number, long time,
			int type,long durations) {
		super();
		this.id = id;
		this.photoId = photoId;
		this.name = name;
		this.number = number;
		this.time = time;
		this.type = type;
		this.durations=durations;
	}
	public long getDurations() {
		return durations;
	}

	public void setDurations(long durations) {
		this.durations = durations;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}



}
