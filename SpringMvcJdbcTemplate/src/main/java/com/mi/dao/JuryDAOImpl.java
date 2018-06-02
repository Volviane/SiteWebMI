package com.mi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mi.model.Cycle;
import com.mi.model.Jury;

@Repository("juryDao")
public class JuryDAOImpl extends AbstractDao<Integer, Jury> implements JuryDAO {

	@Override
	public void save(Jury jury) {
		persist(jury);
		
	}

	@Override
	public void delete(int juryId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Jury findByJuryName(String juryName) {
		// TODO Auto-generated method stub
		return findByName(juryName);
	}

	@Override
	public Jury findOne(int juryId) {
		// TODO Auto-generated method stub
		return getByKey(juryId);
	}

	@Override
	public List<Jury> findAll() {
		@SuppressWarnings("unchecked")
		List<Jury> jury = getEntityManager()
				.createQuery("SELECT u FROM JURY u ORDER BY u.annee ASC")
				.getResultList();
		return jury;
	}

}
