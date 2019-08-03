package com.packt.webstore.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packt.webstore.domain.Contact;

public interface ContactRepositoryJpa  extends JpaRepository<Contact, Long>  {

	List<Contact> findByFirstName(String firstName);

	List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
	
	
	
}
