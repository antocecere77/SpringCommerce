package com.packt.webstore.domain.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.packt.webstore.domain.Contact;

public interface ContactRepository {

	Contact getContactByName(String firstName);

	List<Contact> findAll();
	
	List<Contact> findByFirstName(String firstName);

	List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
	
	Page<Contact> findAll(Pageable pageable);
	
	Contact findOne(Long id);
}
