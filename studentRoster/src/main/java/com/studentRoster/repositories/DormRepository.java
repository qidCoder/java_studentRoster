package com.studentRoster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.studentRoster.models.Dorm;

@Repository
public interface DormRepository extends CrudRepository<Dorm, Long>{
	//SELECT * FROM DLs
	List<Dorm> findAll();
}
