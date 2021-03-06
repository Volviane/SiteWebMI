package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Student;

public interface StudentRepository extends JpaRepository<Student, String>{
	
	public Student findByLogin(String login);
	public Student findByIdStudent(Long idStudent);
	public Student findByMatricule(String matricule);

}
