package com.packt.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.packt.webstore.domain.Contact;
import com.packt.webstore.domain.repository.ContactRepository;
import com.packt.webstore.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contact getContactByName(String firstName) {
		return contactRepository.getContactByName(firstName);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		return Lists.newArrayList(contactRepository.findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contact> findByFirstName(String firstName) {
		return contactRepository.findByFirstName(firstName);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contact> findByFirstNameAndLastName(String firstName, String lastName) {
		return contactRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Contact> findAll(Pageable pageable) {
		return contactRepository.findAll(pageable);
	}

	@Override
	public Contact findOne(Long id) {
		return contactRepository.findOne(id);
	}

}