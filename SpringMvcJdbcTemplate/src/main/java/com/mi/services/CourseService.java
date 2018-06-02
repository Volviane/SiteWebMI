package com.mi.services;

import java.util.List;

import com.mi.model.Course;
import com.mi.model.Option;

public interface CourseService {
	
	Course findById(int id);
	
	Course findByCourseName(String courseName);
	
	void saveCourse(Course course);
	
	void updateCourse(Course course);
	
	void deleteUserBySSO(String sso);

	List<Course> findAllCourses(); 
	
	List<Course> findAllCourseByLevel(int idLevel); 


}
