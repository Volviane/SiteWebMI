package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Administrator;


public interface AdministratorRepository extends JpaRepository<Administrator, String>{
	
	public Administrator findByLogin(String login);


}
