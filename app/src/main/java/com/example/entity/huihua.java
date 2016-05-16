package com.example.entity;

public class huihua {
/*"_id","address","body","status"*/
    private int id;
    private String body;
    private String address;
    private int status;
    
    
//    status=-32  0;
    
	public huihua(int id, String body) {
		this.id = id;
		this.body = body;
	}

	public huihua() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
    
    
}
