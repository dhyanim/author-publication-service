package com.mdhyani.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mdhyani.model.Publication;

@Repository
public interface PublicationRepository extends CrudRepository<Publication, Long> {
	
	List<Publication> findByAuthor_Name(String author);
	
	Publication findByYearAndAuthor_Name(Long year, String author);
	
	Publication findByPublicationTypeAndAuthor_Name(String publicationType, String author);
}
