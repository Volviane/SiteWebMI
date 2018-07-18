package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.AcademicYear;
import com.mi.model.Jury;
import com.mi.model.Teacher;

public interface JuryRepository extends JpaRepository<Jury, String>{
	public Jury findByAcademicYear(AcademicYear academicYear);
	
	public Jury findByJuryPresident(Teacher juryPresident);

}
