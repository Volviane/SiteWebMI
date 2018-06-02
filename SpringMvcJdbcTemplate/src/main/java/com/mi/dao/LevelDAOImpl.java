package com.mi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mi.model.Level;

@Repository("levelDao")
public class LevelDAOImpl  extends AbstractDao<Integer, Level>  implements LevelDAO  {

	@Override
	public void save(Level level) {
		persist(level);
		
	}

	@Override
	public void delete(int levelId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Level findByLevelName(String levelName) {
		// TODO Auto-generated method stub
		return findByName(levelName);
	}

	@Override
	public Level findOne(int levelId) {
		// TODO Auto-generated method stub
		return getByKey(levelId);
	}

	@Override
	public List<Level> findAll() {
		@SuppressWarnings("unchecked")
		List<Level> level = getEntityManager()
				.createQuery("SELECT u FROM NIVEAU u ORDER BY u.nomNiveau ASC")
				.getResultList();
		return level;
	}

}
