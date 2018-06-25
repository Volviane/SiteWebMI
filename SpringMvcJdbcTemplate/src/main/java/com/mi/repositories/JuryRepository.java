package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Jury;

public interface JuryRepository extends JpaRepository<Jury, String>{
	public Jury findByAcademicYear(String academicYear);

}
