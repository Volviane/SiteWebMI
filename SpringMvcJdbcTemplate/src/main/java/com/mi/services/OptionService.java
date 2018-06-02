package com.mi.services;

import java.util.List;

import com.mi.model.Option;

public interface OptionService {
	Option findById(int id);
	
	Option findByOptionName(String cycleName);
	
	void saveOption(Option option);
	
	void updateOption(Option option);
	
	void deleteUserBySSO(String sso);

	List<Option> findAllOptions(); 
	
	List<Option> findAllOptionsByCycle(int idCycle); 
}


