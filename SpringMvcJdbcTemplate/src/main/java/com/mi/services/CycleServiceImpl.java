package com.mi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mi.dao.CycleDAO;

import com.mi.model.Cycle;

@Service("cycleService")
@Transactional
public class CycleServiceImpl  implements CycleService{
	
	@Autowired
	CycleDAO cycleDao;
	
	@Override
	public Cycle findById(int id) {
		// TODO Auto-generated method stub
		return cycleDao.findOne(id);
	}

	@Override
	public Cycle findByCycleName(String cycleName) {
		// TODO Auto-generated method stub
		return cycleDao.findByCycleName(cycleName);
	}

	@Override
	public void saveCycle(Cycle cycle) {
		cycleDao.save(cycle);
		
	}

	@Override
	public void updateCycle(Cycle cycle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserBySSO(String sso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cycle> findAllCycles() {
		// TODO Auto-generated method stub
		return cycleDao.findAll();
	}

}
