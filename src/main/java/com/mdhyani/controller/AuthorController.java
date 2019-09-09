package com.mdhyani.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdhyani.dao.AuthorDao;
import com.mdhyani.model.Author;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	@Autowired
	private AuthorDao authorDAO;
	
	@RequestMapping(value = "/",  method= RequestMethod.POST)
	public Author saveAuthor(@RequestBody Author author) {
		return authorDAO.save(author);
	}
	
	@RequestMapping(value = "/",  method= RequestMethod.PUT)
	public Author updateAuthor(@RequestBody Author author) {
		return authorDAO.update(author);
	}
	
	@RequestMapping(value = "/authors",  method= RequestMethod.GET)
	public List<Author> getAllAuthors() {
		return authorDAO.getAuthors();
	}
	
	@RequestMapping(value = "/{Id}", method= RequestMethod.GET)
	public Author getAuthorById(@PathVariable("Id") Long Id) {
		return authorDAO.getAuthorById(Id);
	}

}
