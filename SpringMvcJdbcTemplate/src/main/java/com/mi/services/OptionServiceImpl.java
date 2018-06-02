package com.mi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mi.dao.OptionDAO;
import com.mi.model.Option;

@Service("optionService")
@Transactional
public class OptionServiceImpl implements OptionService {
	@Autowired
	OptionDAO optionDAO;
	@Override
	public Option findById(int id) {
		// TODO Auto-generated method stub
		return optionDAO.findOne(id);
	}

	@Override
	public Option findByOptionName(String optionName) {
		// TODO Auto-generated method stub
		return optionDAO.findByOptionName(optionName);
	}

	@Override
	public void saveOption(Option option) {
		// TODO Auto-generated method stub
		optionDAO.save(option);
		
	}

	@Override
	public void updateOption(Option option) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserBySSO(String sso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Option> findAllOptions() {
		// TODO Auto-generated method stub
		return optionDAO.findAll();
	}

	@Override
	public List<Option> findAllOptionsByCycle(int idCycle) {
		// TODO Auto-generated method stub
		return optionDAO.findByCycle(idCycle);
	}

}
