package com.packt.webstore.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.packt.webstore.domain.Contact;

public interface ContactService {
	
	List<Contact> findAll();
	
	List<Contact> findByFirstName(String firstName);

	List<Contact> findByFirstNameAndLastName(String firstName, String lastName);

	Contact getContactByName(String firstName);
	
	Page<Contact> findAll(Pageable pageable);
	
	Contact findOne(Long id);
	
}
