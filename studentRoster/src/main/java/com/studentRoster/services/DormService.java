package com.studentRoster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentRoster.models.Dorm;
import com.studentRoster.repositories.DormRepository;

@Service
public class DormService {
	//Dependency Injection
	private DormRepository dormRepo;
	
	//constructor
	public DormService(DormRepository repo) {
		this.dormRepo = repo;
	}
	
	//CRUD Methods
	//Get All dorms
	public List<Dorm> getAllDorms(){
		return this.dormRepo.findAll();
	}
	
	//Get one dorm
	public Dorm getSingleDorm(Long id) {
		return this.dormRepo.findById(id).orElse(null);
	}

	//Create a dorm
	public Dorm createDorm(Dorm newDorm) {

		return this.dormRepo.save(newDorm);
	}
	
	//Delete a dorm
	//NOTE: this only deletes the dorm if it has no students assigned to it!
	public void deleteDorm(Long id) {
		this.dormRepo.deleteById(id);
	}
	

	
	


}
