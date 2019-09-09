package com.mdhyani.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdhyani.dao.PublicationDAO;
import com.mdhyani.model.Publication;
import com.mdhyani.repository.PublicationRepository;

@Service
public class PublicationDAOImpl implements PublicationDAO {
	
	@Autowired
	private PublicationRepository publicationRepository;

	@Override
	public Publication save(Publication publication) {
		return publicationRepository.save(publication);
	}

	@Override
	public List<Publication> getPublications() {
		return (List<Publication>) publicationRepository.findAll();
	}

	@Override
	public Publication getPublicationById(Long Id) {
		return publicationRepository.findById(Id).get();
	}

	@Override
	public Publication getPublicationByYearAndAuthor(Long year, String author) {
		return publicationRepository.findByYearAndAuthor_Name(year, author);
	}

	@Override
	public List<Publication> getPublicationsByAuthor(String author) {
		return publicationRepository.findByAuthor_Name(author);
	}

	@Override
	public Publication getPublicationByTypeAndAuthor(String publicationType, String author) {
		return publicationRepository.findByPublicationTypeAndAuthor_Name(publicationType, author);
	}

	@Override
	public Publication update(Publication publication) {
		Publication publicationDB = getPublicationById(publication.getId());
		publicationDB.setTitle(publication.getTitle());
		publicationDB.setYear(publication.getYear());
		return publicationRepository.save(publicationDB);
	}

}
