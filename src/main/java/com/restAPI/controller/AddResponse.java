package com.restAPI.controller;

public class AddResponse {

	
	int id;
	String msg;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public AddResponse() {
		super();
		this.id = id;
		this.msg = msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
