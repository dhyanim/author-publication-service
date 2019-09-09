package com.mdhyani.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity  
@DiscriminatorValue("magazine")  
public class Magazine extends Publication {

	public Magazine() {
		
	}
	
	public Magazine(String title, long year) {
		super(title, year);
	}

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
