package com.studentRoster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.studentRoster.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{
	//SELECT * FROM DLs
	List<Contact> findAll();
}
