package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Student;

public interface StudentRepository extends JpaRepository<Student, String>{
	
	public Student findByLogin(String login);

}
