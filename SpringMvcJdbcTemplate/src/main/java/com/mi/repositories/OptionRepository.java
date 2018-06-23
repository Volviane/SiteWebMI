package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mi.model.Option;

public interface OptionRepository  extends JpaRepository<Option, String>{
	
	public Option findByOptionName(String optionName);

}
