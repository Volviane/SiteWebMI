package com.mi.services;

import java.util.List;

import com.mi.model.Teachers;

public interface TeachersService {
	
	Teachers findById(int id);
	
	Teachers findByTeachersName(String teachersName);
	
	void saveTeachers(Teachers teacher);
	
	void updateTeachers(Teachers teacher);
	
	void deleteUserBySSO(String sso);

	List<Teachers> findAllTeachers(); 
}


