package com.mi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mi.dao.CourseDAO;
import com.mi.model.Course;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDAO courseDAO;
	
	@Override
	public Course findById(int id) {
		// TODO Auto-generated method stub
		return courseDAO.findOne(id);
	}

	@Override
	public Course findByCourseName(String courseName) {
		// TODO Auto-generated method stub
		return courseDAO.findByCourseName(courseName);
	}

	@Override
	public void saveCourse(Course course) {
		// TODO Auto-generated method stub
		courseDAO.save(course);
		
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserBySSO(String sso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Course> findAllCourses() {
		// TODO Auto-generated method stub
		return courseDAO.findAll();
	}

	@Override
	public List<Course> findAllCourseByLevel(int idLevel) {
		// TODO Auto-generated method stub
		return courseDAO.findByLevel(idLevel);
	}

}
