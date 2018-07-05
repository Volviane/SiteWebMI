package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Teacher;

public interface TeachersRepository extends JpaRepository<Teacher, String>{
	public Teacher findByLastName(String lastName);
	public Teacher findByLogin(String login);
}
