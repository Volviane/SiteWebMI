package com.mi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mi.model.Cycle;
import com.mi.model.Teachers;

@Repository("teachersDAO")
public class TeachersDAOImpl extends AbstractDao<Integer, Teachers> implements TeachersDAO{

	@Override
	public void save(Teachers teachers) {
		persist(teachers);
		
	}

	@Override
	public void delete(int teachersId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Teachers findByteachersName(String teachersName) {
		// TODO Auto-generated method stub
		return findByName(teachersName);
	}

	@Override
	public Teachers findOne(int teachersId) {
		// TODO Auto-generated method stub
		return getByKey(teachersId);
	}

	@Override
	public List<Teachers> findAll() {
		@SuppressWarnings("unchecked")
		List<Teachers> teachers = getEntityManager()
				.createQuery("SELECT u FROM ENSEIGNANT u ORDER BY u.nom ASC")
				.getResultList();
		return teachers;
	}

}
