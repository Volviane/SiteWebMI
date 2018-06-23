package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Grade;

public interface GradeRepository extends JpaRepository<Grade, String>{
	public Grade findByGradeName(String gradeName);

}
