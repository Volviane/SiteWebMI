package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Teachers;

public interface TeachersRepository extends JpaRepository<Teachers, String>{
	public Teachers findByLastName(String lastName);

}
