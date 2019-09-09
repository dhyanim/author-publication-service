package com.mdhyani.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="author")
public class Author {
	
	
	public Author() {
		
	}
	
	public Author(String name) {
		super();
		this.name = name;
	}
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {  CascadeType.PERSIST,
            CascadeType.MERGE } )
    @JoinTable(name = "author_publication", joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "publication_id", referencedColumnName = "id"))
	private Set<Publication> publication = new HashSet<>();
	
	
	@JsonBackReference
	public Set<Publication> getPublication() {
		return publication;
	}
	public void setPublication(Set<Publication> publication) {
		this.publication = publication;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
