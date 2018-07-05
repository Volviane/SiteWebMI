package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mi.model.Option;

public interface OptionRepository  extends JpaRepository<Option, String>{
	
	public Option findByOptionName(String optionName);
	@Query("select c from Option c where c.idOption=:x")
	public Option getOptionById(@Param("x") int id);

}
