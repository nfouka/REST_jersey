package com.mkyong;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AllSigned {
	private List<FileName> list  ;

	public List<FileName> getList() {
		return list;
	}

	public void setList(List<FileName> list) {
		this.list = list;
	} 
	
}
