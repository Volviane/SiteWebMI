package com.mi.dao;

import java.util.List;

import com.mi.model.Cycle;
import com.mi.model.Option;

public interface OptionDAO {
	public void save(Option option);
	public void delete(int optionId);
	public Option findByOptionName(String optionName);
	public Option findOne(int optionId);
	public List<Option> findAll();
	public List<Option> findByCycle(Integer idCycle);
}
