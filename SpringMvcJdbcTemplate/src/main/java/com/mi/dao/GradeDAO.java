package com.mi.dao;

import java.util.List;

import com.mi.model.Grade;

public interface GradeDAO {
	
	public void save(Grade grade);
	public void delete(int gradeId);
	public Grade findByGradeName(String gradeName);
	public Grade findOne(int gradeId);
	public List<Grade> findAll();

}
