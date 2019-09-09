package com.mdhyani;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mdhyani.dao.AuthorDao;
import com.mdhyani.model.Author;
import com.mdhyani.model.Book;
import com.mdhyani.model.Comics;
import com.mdhyani.model.Magazine;

@SpringBootApplication
public class SpringBootInitializer {
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootInitializer.class, args);
	}

	@Bean
    public CommandLineRunner init(AuthorDao authorDAO) {
		
        return args -> { 
			
        	// Initializing with some default data 
        	// Using In memory H2 database with Spring JPA
        	
			  Author author1 = new Author("Michael Hank"); 
			  Comics comics = new Comics("Batman", 2019);
			  comics.setHero("Tom Hanks");
			  comics.getAuthor().add(author1);
			  author1.getPublication().add(comics);
			  
			  Author author2 = new Author("Jack Walker"); 
			  Magazine magazine = new Magazine("Forbes", 2018);
			  magazine.setType("Printed");
			  magazine.getAuthor().add(author2);
			  author2.getPublication().add(magazine);
			  
			  Author author3 = new Author("JK Rowling"); 
			  Book book = new Book("Harry Potter", 2008);
			  book.setGenre("Novel");
			  book.getAuthor().add(author3);
			  author3.getPublication().add(book);
			  
			  authorDAO.save(author1);
			  authorDAO.save(author2);
			  authorDAO.save(author3);
			 
        };
    }
}
