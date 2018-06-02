package com.mi.dao;

import java.util.List;

import com.mi.model.Level;

public interface LevelDAO {

	public void save(Level level);
	public void delete(int levelId);
	public Level findByLevelName(String levelName);
	public Level findOne(int levelId);
	public List<Level> findAll();

}
