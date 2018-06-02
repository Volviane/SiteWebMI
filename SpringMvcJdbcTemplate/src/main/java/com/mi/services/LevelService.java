package com.mi.services;

import java.util.List;

import com.mi.model.Level;

public interface LevelService {
	
	Level findById(int id);
	
	Level findByLevelName(String levelName);
	
	void saveLevel(Level level);
	
	void updateLevel(Level level);
	
	void deleteUserBySSO(String sso);

	List<Level> findAllLevels(); 

}
