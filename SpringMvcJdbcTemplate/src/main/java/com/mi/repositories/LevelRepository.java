package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mi.model.Level;

public interface LevelRepository extends JpaRepository<Level, String> {
	public Level findByLevelName(String levelName);
}
