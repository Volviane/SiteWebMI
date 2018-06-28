package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.AcademicYear;


public interface AcademicYearRepository extends JpaRepository<AcademicYear, String>{
	public AcademicYear findByAcademicYear(String academicYear);
	
	public AcademicYear findByStatus(String status);

}
