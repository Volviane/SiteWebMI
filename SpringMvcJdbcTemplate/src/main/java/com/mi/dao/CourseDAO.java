package com.mi.dao;

import java.util.List;

import com.mi.model.Course;
import com.mi.model.Option;

public interface CourseDAO {

	public void save(Course course);
	public void delete(int courseId);
	public Course findByCourseName(String courseName);
	public Course findOne(int courseId);
	public List<Course> findAll();
	public List<Course> findByLevel(Integer idLevel);

}
