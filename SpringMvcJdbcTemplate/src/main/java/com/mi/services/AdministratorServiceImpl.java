package com.mi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mi.dao.AdministratorDAO;
import com.mi.model.Administrator;

@Service("administratorService")
@Transactional
public class AdministratorServiceImpl implements AdministratorService {

	@Autowired 
	AdministratorDAO adminDao;
	
	public Administrator findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Administrator findByLoginAdmin(String loginAdmin) {
		// TODO Auto-generated method stub
		return adminDao.findByLogin(loginAdmin);
	}

	
	public void saveAdministrator(Administrator administrator) {
		adminDao.save(administrator);
		
	}

	@Override
	public void updateAdministrator(Administrator role) {
		// TODO Auto-generated method stub
		
	}

}
