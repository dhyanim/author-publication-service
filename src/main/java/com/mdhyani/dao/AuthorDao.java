package com.mdhyani.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mdhyani.model.Author;

@Service
public interface AuthorDao {
	
	public Author save(Author author);
	
	public Author update(Author author);
	
	public List<Author> getAuthors();
	
	public Author getAuthorById(Long Id);

}
