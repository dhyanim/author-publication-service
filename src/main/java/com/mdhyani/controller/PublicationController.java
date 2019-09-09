package com.mdhyani.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdhyani.dao.PublicationDAO;
import com.mdhyani.model.Publication;

@RestController
@RequestMapping("/publication")
public class PublicationController {

	@Autowired
	PublicationDAO publicationDAO;
	
	
	@RequestMapping(value = "/", method= RequestMethod.POST)
	public Publication savePublication(@RequestBody Publication publication) {
		return publicationDAO.save(publication);
	}
	
	@RequestMapping(value = "/", method= RequestMethod.PUT)
	public Publication updatePublication(@RequestBody Publication publication) {
		return publicationDAO.update(publication);
	}
	
	//API e.g : http://localhost:8080/publication/publications
	@RequestMapping(value = "/publications", method = RequestMethod.GET)
	public List<Publication> getAllPublications() {
		return publicationDAO.getPublications();
	}
	
	//API e.g : http://localhost:8080/publication/search/author/year?author=Jack%20Walker&year=2018
	@RequestMapping(value = "/search/author/year", method = RequestMethod.GET)
	public Publication getPublicationByYearAndAuthor(@RequestParam("year") Long year, 
			@RequestParam("author") String author) {
		return publicationDAO.getPublicationByYearAndAuthor(year, author);
	}
	
	// API e.g : http://localhost:8080/publication/search/author/Michael%20Hank
	@RequestMapping(value = "/search/author/{author}", method = RequestMethod.GET)
	public List<Publication> getPublicationsByAuthor(@PathVariable("author") String author) {
		return publicationDAO.getPublicationsByAuthor(author);
	}
	
	//API e.g : http://localhost:8080/publication/search/type/author?author=Michael%20Hank&type=comics
	@RequestMapping(value = "/search/type/author", method = RequestMethod.GET)
	public Publication getPublicationByTypeAndAuthor(@RequestParam("author") String author, 
			@RequestParam("type") String type) {
		return publicationDAO.getPublicationByTypeAndAuthor(type, author);
	}
	
	
}
