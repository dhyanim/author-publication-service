package com.mdhyani.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mdhyani.model.Publication;

@Service
public interface PublicationDAO {
	
	public Publication save(Publication publication);
	
	public List<Publication> getPublications();
	
	public List<Publication> getPublicationsByAuthor(String author);
	
	public Publication getPublicationById(Long Id);
	
	public Publication getPublicationByYearAndAuthor(Long year, String author);
	
	public Publication getPublicationByTypeAndAuthor(String publicationType, String author);

	public Publication update(Publication publication);
	
}
