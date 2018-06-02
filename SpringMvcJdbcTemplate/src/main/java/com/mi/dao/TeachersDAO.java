package com.mi.dao;

import java.util.List;

import com.mi.model.Teachers;

public interface TeachersDAO {
	
	public void save(Teachers teachers);
	public void delete(int teachersId);
	public Teachers findByteachersName(String teachersName);
	public Teachers findOne(int teachersId);
	public List<Teachers> findAll();

}
