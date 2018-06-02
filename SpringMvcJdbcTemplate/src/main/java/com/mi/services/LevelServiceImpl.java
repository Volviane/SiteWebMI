package com.mi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mi.dao.LevelDAO;
import com.mi.model.Level;

@Service("levelService")
@Transactional
public class LevelServiceImpl  implements LevelService{
	@Autowired
	LevelDAO levelDAO;
	
	@Override
	public Level findById(int id) {
		// TODO Auto-generated method stub
		return levelDAO.findOne(id);
	}

	@Override
	public Level findByLevelName(String levelName) {
		// TODO Auto-generated method stub
		return levelDAO.findByLevelName(levelName);
	}

	@Override
	public void saveLevel(Level level) {
		levelDAO.save(level);
		
	}

	@Override
	public void updateLevel(Level level) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserBySSO(String sso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Level> findAllLevels() {
		// TODO Auto-generated method stub
		return levelDAO.findAll();
	}

}
