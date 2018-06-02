package com.mi.services;

import java.util.List;

import com.mi.model.Grade;

public interface GradeService {
	Grade findById(int id);
	
	Grade findByGradeName(String gradeName);
	
	void saveGrade(Grade grade);
	
	void updateLevel(Grade grade);
	
	void deleteUserBySSO(String sso);

	List<Grade> findAllGrades(); 
}
