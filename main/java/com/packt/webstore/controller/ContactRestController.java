package com.packt.webstore.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.packt.webstore.domain.Contact;
import com.packt.webstore.service.ContactService;

@RestController
@RequestMapping(value = "rest/contact")
public class ContactRestController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/{contactId}", method = RequestMethod.GET)
	public Contact getContactById(@PathVariable(value = "contactId") Long contactId) {
		return contactService.findOne(contactId);
	}

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public Page<Contact> getContactPaginated(@RequestParam("size") int size, @RequestParam("page") int page) {

		Pageable pageable = new PageRequest(page, size, new Sort(Sort.Direction.ASC, "lastName"));

		Page<Contact> contacts = contactService.findAll(pageable);
		List<Contact> result = new LinkedList<>();
		for (Contact contact : contacts) {
			result.add(contact);
		}
		return new PageImpl<>(result, pageable, contacts.getTotalElements());
	}

}
