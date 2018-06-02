package com.mi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mi.dao.TeachersDAO;
import com.mi.model.Teachers;

@Service("teachersService")
@Transactional
public class TeachersServiceImpl  implements TeachersService {

	@Autowired
	TeachersDAO teachersDAO;
	
	@Override
	public Teachers findById(int id) {
		// TODO Auto-generated method stub
		return teachersDAO.findOne(id);
	}

	@Override
	public Teachers findByTeachersName(String teachersName) {
		// TODO Auto-generated method stub
		return teachersDAO.findByteachersName(teachersName);
	}

	@Override
	public void saveTeachers(Teachers teachers) {
		teachersDAO.save(teachers);
		
	}

	@Override
	public void updateTeachers(Teachers teacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserBySSO(String sso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Teachers> findAllTeachers() {
		// TODO Auto-generated method stub
		return teachersDAO.findAll();
	}

}
