package com.mi.services;

import com.mi.model.Administrator;


public interface AdministratorService {
	
	Administrator findById(int id);
	
	Administrator findByLoginAdmin(String loginAdmin);
	
	void saveAdministrator(Administrator user);
	
	void updateAdministrator(Administrator role);
	

}
