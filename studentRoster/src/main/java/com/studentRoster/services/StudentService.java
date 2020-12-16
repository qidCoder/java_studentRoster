package com.studentRoster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentRoster.models.Student;
import com.studentRoster.repositories.StudentRepository;

@Service
public class StudentService {
	//Dependency Injection
	private StudentRepository studentRepo;
	
	//constructor
	public StudentService(StudentRepository repo) {
		this.studentRepo = repo;
	}
	
	//CRUD Methods
	//Get All students
	public List<Student> getAllStudents(){
		return this.studentRepo.findAll();
	}
	
	//Get one student
	public Student getSingleStudent(Long id) {
		return this.studentRepo.findById(id).orElse(null);
	}
	
	//Create a student
	public Student createStudent(Student newStudent) {
		return this.studentRepo.save(newStudent);
	}

	
	//Delete a student
	public void deleteStudent(Long id) {
		this.studentRepo.deleteById(id);
	}
}
