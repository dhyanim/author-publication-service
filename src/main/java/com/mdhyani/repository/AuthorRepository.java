package com.mdhyani.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mdhyani.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
