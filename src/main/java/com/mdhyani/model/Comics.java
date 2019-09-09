package com.mdhyani.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity  
@DiscriminatorValue("comics")  
public class Comics extends Publication {

	public Comics() {
		
	}
	
	public Comics(String title, long year) {
		super(title, year);
	}
	
	private String hero;

	public String getHero() {
		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

}
