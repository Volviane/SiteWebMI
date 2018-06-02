package com.mi.services;

import java.util.List;

import com.mi.model.Cycle;

public interface CycleService {
	Cycle findById(int id);
	
	Cycle findByCycleName(String cycleName);
	
	void saveCycle(Cycle cycle);
	
	void updateCycle(Cycle cycle);
	
	void deleteUserBySSO(String sso);

	List<Cycle> findAllCycles(); 
}
