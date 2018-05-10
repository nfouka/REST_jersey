package com.mkyong;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RESULT SIGNATURE API AWS")
public class FileName {
	
	private String fileName  ;
	private Boolean validate  ; 
	private String date ; 
	private Track track ; 

	public String getFileName() {
		return fileName;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Boolean getValidate() {
		return validate;
	}

	public void setValidate(Boolean validate) {
		this.validate = validate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	} 
	
	

}
