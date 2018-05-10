package com.mkyong.rest;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class files {
	
	private List<String> list ;
	private String id ; 

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "files [list=" + list + ", id=" + id + "]";
	} 
	
	

}
