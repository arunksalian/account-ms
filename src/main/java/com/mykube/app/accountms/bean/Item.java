package com.mykube.app.accountms.bean;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;


public class Item implements Serializable {

	private String name;
	private int num;
	private int hits;
	
	
	public Item(String name, int num, int hits) {
		super();
		this.name = name;
		this.num = num;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
