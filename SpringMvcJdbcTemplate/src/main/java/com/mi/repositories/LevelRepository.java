package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mi.model.Level;
import com.mi.model.Option;

public interface LevelRepository extends JpaRepository<Level, Integer> {
	public Level findByLevelName(String levelName);
	public Level findByLevelNameAndOption(String levelName, Option option);
}
