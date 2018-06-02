package com.mi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mi.model.Cycle;
import com.mi.model.Option;

@Repository("optionDao")
public class OptionDAOImpl extends AbstractDao<Integer, Option> implements OptionDAO{

	@Override
	public void save(Option option) {
		persist(option);
		
	}

	@Override
	public void delete(int optionId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Option findByOptionName(String optionName) {
		// TODO Auto-generated method stub
		return findByName(optionName);
	}

	@Override
	public Option findOne(int optionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Option> findAll() {
		List<Option> option = getEntityManager()
				.createQuery("SELECT u FROM OPTION u ORDER BY u.optionName ASC")
				.getResultList();
		return option;
	}

	@Override
	public List<Option> findByCycle(Integer idCycle) {
		@SuppressWarnings("unchecked")
		List<Option> option = getEntityManager()
				.createQuery("SELECT u FROM OPTION WHERE u.IDCYCLE=idCycle")
				.getResultList();
		return option;
	}

}
