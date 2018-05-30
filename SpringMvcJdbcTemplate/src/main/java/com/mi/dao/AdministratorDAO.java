package com.mi.dao;



import com.mi.model.Administrator;



public interface AdministratorDAO  {
	
	public void save(Administrator administrator);
	public void delete(int administratorId);
	public Administrator findByLogin(String login);

}
