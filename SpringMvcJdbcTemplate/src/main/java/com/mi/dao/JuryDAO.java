package com.mi.dao;

import java.util.List;

import com.mi.model.Jury;

public interface JuryDAO {
	
	public void save(Jury jury);
	public void delete(int juryId);
	public Jury findByJuryName(String juryName);
	public Jury findOne(int juryId);
	public List<Jury> findAll();

}
