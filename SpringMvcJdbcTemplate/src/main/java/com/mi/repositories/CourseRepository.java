package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Course;
import com.mi.model.Level;



public interface CourseRepository extends JpaRepository<Course, Integer>{
	public Course findByCourseCode(String courseCode);
	public Course findByCourseCodeAndLevel(String courseCode,Level level);
}
