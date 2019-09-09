package com.mdhyani.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdhyani.dao.AuthorDao;
import com.mdhyani.model.Author;
import com.mdhyani.repository.AuthorRepository;

@Service
public class AuthorDAOImpl implements AuthorDao {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Author save(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public List<Author> getAuthors() {
		return (List<Author>) authorRepository.findAll();
	}

	@Override
	public Author getAuthorById(Long Id) {
		return authorRepository.findById(Id).get();
	}

	@Override
	public Author update(Author author) {
		Author authorDB = getAuthorById(author.getId());
		authorDB.setName(author.getName());
		return authorRepository.save(authorDB);
	}

}
