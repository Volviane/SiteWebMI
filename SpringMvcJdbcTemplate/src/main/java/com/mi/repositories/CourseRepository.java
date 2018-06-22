package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Course;

public interface CourseRepository extends JpaRepository<Course, String> {

}
