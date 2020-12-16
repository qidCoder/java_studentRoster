package com.studentRoster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.studentRoster.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
	//SELECT * FROM DLs
	List<Student> findAll();
}
