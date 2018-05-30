package com.mi.dao;

import org.springframework.stereotype.Repository;

import com.mi.model.Administrator;

@Repository("administratorDao")
public class AdministratorDAOImpl extends AbstractDao<Integer, Administrator> implements AdministratorDAO{

	

	@Override
	public void delete(int administratorId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Administrator findByLogin(String login) {
		// TODO Auto-generated method stub
	
		return findByName(login);
	}

	@Override
	public void save(Administrator administrator) {
		persist(administrator);
		
	}
	

}
