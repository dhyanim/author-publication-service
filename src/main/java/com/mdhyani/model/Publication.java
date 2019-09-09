package com.mdhyani.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="publication")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  
@DiscriminatorColumn(name="publication_type",discriminatorType = DiscriminatorType.STRING)  
@DiscriminatorValue(value="publication")  
public class Publication {
	
	public Publication() {
		super();
	}
	
	public Publication(String title, long year) {
		super();
		this.title = title;
		this.year = year;
	}
	
	
	@Id
	@GeneratedValue
	private long id;

	private String title;
	
	@Column(name="publication_type", insertable = false, updatable = false)
	protected String publicationType;
	
	public String getPublicationType() {
		return publicationType;
	}

	public void setPublicationType(String publicationType) {
		this.publicationType = publicationType;
	}


	@ManyToMany(fetch = FetchType.LAZY, cascade = {  CascadeType.PERSIST,
            CascadeType.MERGE }, mappedBy = "publication")
	private Set<Author> author = new HashSet<Author>();
	
	@JsonBackReference
	public Set<Author> getAuthor() {
		return author;
	}
	public void setAuthor(Set<Author> author) {
		this.author = author;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	private long year;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}

}
