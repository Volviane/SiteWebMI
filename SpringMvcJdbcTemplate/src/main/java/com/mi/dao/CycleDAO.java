package com.mi.dao;

import java.util.List;

import com.mi.model.Cycle;

public interface CycleDAO {

	public void save(Cycle cycle);
	public void delete(int cycleId);
	public Cycle findByCycleName(String cycleName);
	public Cycle findOne(int cycleId);
	public List<Cycle> findAll();
	
}
