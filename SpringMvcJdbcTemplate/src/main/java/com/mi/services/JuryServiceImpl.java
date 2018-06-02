package com.mi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mi.dao.JuryDAO;
import com.mi.model.Jury;

@Service("juryService")
@Transactional
public class JuryServiceImpl implements JuryService {

	@Autowired
	JuryDAO juryDAO;
	
	@Override
	public Jury findById(int id) {
		// TODO Auto-generated method stub
		return juryDAO.findOne(id);
	}

	@Override
	public Jury findByJuryName(String juryName) {
		// TODO Auto-generated method stub
		return juryDAO.findByJuryName(juryName);
	}

	@Override
	public void saveJury(Jury jury) {
		juryDAO.save(jury);
		
	}

	@Override
	public void updateJury(Jury jury) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserBySSO(String sso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Jury> findAllJurys() {
		// TODO Auto-generated method stub
		return juryDAO.findAll();
	}

}
