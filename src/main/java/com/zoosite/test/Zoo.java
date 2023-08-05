package com.zoosite.test;

import java.io.Serializable;

public class Zoo implements Serializable{
	private int zoo_id;
	private String zoo_name;
	private String state;
	private String city;
	private int area;
	private int activity;
	public Zoo() { 
		this.activity =1;
	}
	public int getZoo_id() {
		return zoo_id;
	}
	public void setZoo_id(int zoo_id) {
		this.zoo_id = zoo_id;
	}
	public String getZoo_name() {
		return zoo_name;
	}
	public void setZoo_name(String zoo_name) {
		this.zoo_name = zoo_name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getActivity() {
		return activity;
	}
	public void setActivity(int activity) {
		this.activity = activity;
	}
	
}
