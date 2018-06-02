package com.mi.services;

import java.util.List;

import com.mi.model.Jury;

public interface JuryService {
	
	Jury findById(int id);
	
	Jury findByJuryName(String juryName);
	
	void saveJury(Jury jury);
	
	void updateJury(Jury jury);
	
	void deleteUserBySSO(String sso);

	List<Jury> findAllJurys(); 

}
