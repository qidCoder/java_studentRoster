package com.studentRoster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentRoster.models.Contact;
import com.studentRoster.repositories.ContactRepository;

@Service
public class ContactService {
	//Dependency Injection
	private ContactRepository contactRepo;
	
	//constructor
	public ContactService(ContactRepository repo) {
		this.contactRepo = repo;
	}
	
	//CRUD Methods
	//Get All contacts
	public List<Contact> getAllContacts(){
		return this.contactRepo.findAll();
	}
	
	//Get one contact
	public Contact getSingleContact(Long id) {
		return this.contactRepo.findById(id).orElse(null);
	}

	//Create a contact
	public Contact createContact(Contact newContact) {

		return this.contactRepo.save(newContact);
	}
	


}
