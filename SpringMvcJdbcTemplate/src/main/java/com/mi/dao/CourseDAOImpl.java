package com.mi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mi.model.Course;
import com.mi.model.Level;
import com.mi.model.Option;

@Repository("courseDao")
public class CourseDAOImpl  extends AbstractDao<Integer, Course> implements CourseDAO {

	@Override
	public void save(Course course) {
		persist(course);
		
	}

	@Override
	public void delete(int courseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Course findByCourseName(String courseName) {
		// TODO Auto-generated method stub
		return findByName(courseName);
	}

	@Override
	public Course findOne(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAll() {
		@SuppressWarnings("unchecked")
		List<Course> course = getEntityManager()
				.createQuery("SELECT u FROM UV u ORDER BY u.intituleUV ASC")
				.getResultList();
		return course;
	}

	@Override
	public List<Course> findByLevel(Integer idLevel) {
		@SuppressWarnings("unchecked")
		List<Course> level = getEntityManager()
				.createQuery("SELECT u FROM UV WHERE u.IDNIVEAU=idLevel")
				.getResultList();
		return level;
	}

}
