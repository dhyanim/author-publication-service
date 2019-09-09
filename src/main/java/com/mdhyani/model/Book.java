package com.mdhyani.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity  
@DiscriminatorValue("book")  
public class Book extends Publication {
	
	public Book() {
		
	}

	public Book(String title, long year) {
		super(title, year);
	}
	
	private String genre;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
