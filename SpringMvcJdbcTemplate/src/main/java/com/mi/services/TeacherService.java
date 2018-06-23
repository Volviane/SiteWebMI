package com.mi.services;

import java.util.List;

import com.mi.model.Teacher;


public interface TeacherService {

	Teacher findById(int id);
	
	Teacher findByTeacherName(String teachersName);
	
	void saveTeacher(Teacher teacher);
	
	void updateTeacher(Teacher teacher);
	
	void deleteUserBySSO(String sso);

	List<Teacher> findAllTeacher();
}
