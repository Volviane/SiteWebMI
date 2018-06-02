package com.mi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mi.dao.GradeDAO;

import com.mi.model.Grade;

@Service("gradeService")
@Transactional
public class GradeServiceImpl implements GradeService {

	@Autowired
	GradeDAO gradeDAO;
	
	@Override
	public Grade findById(int id) {
		// TODO Auto-generated method stub
		return gradeDAO.findOne(id);
	}

	@Override
	public Grade findByGradeName(String gradeName) {
		// TODO Auto-generated method stub
		return gradeDAO.findByGradeName(gradeName);
	}

	@Override
	public void saveGrade(Grade grade) {
		gradeDAO.save(grade);
		
	}

	@Override
	public void updateLevel(Grade grade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserBySSO(String sso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Grade> findAllGrades() {
		// TODO Auto-generated method stub
		return gradeDAO.findAll();
	}
	

}
