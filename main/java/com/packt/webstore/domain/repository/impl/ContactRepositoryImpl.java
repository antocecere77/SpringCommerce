package com.packt.webstore.domain.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.packt.webstore.domain.Contact;
import com.packt.webstore.domain.repository.ContactRepository;
import com.packt.webstore.domain.repository.ContactRepositoryJpa;

@Repository
@Transactional
public class ContactRepositoryImpl implements ContactRepository {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ContactRepositoryJpa contactRepositoryJpa;

	@Override
	public Contact getContactByName(String firstName) {
		TypedQuery<Contact> sqlQuery = em.createQuery("from Contact c where c.firstName = ? ", Contact.class);
		sqlQuery.setParameter(1, firstName);
		return sqlQuery.getSingleResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		return Lists.newArrayList(contactRepositoryJpa.findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contact> findByFirstName(String firstName) {
		return contactRepositoryJpa.findByFirstName(firstName);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contact> findByFirstNameAndLastName(String firstName, String lastName) {
		return contactRepositoryJpa.findByFirstNameAndLastName(firstName, lastName);
	}
	
	@Override
	public Page<Contact> findAll(Pageable pageable) {		
		return contactRepositoryJpa.findAll(pageable);
	}

	@Override
	public Contact findOne(Long id) {
		return contactRepositoryJpa.findOne(id);
	}

}
