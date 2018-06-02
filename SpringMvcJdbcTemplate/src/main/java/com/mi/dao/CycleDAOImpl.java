package com.mi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mi.model.Cycle;


@Repository("cycleDao")
public class CycleDAOImpl  extends AbstractDao<Integer, Cycle>  implements CycleDAO{

	@Override
	public void save(Cycle cycle) {
		persist(cycle);
		
	}

	@Override
	public void delete(int cycleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cycle findByCycleName(String cycleName) {
		// TODO Auto-generated method stub
		return findByName(cycleName);
	}

	@Override
	public Cycle findOne(int cycleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cycle> findAll() {
		List<Cycle> cycle = getEntityManager()
				.createQuery("SELECT u FROM CYCLE u ORDER BY u.cycleName ASC")
				.getResultList();
		return cycle;
	}

}
