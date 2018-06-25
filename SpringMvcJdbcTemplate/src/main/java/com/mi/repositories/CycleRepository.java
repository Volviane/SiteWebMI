package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Cycle;


public interface CycleRepository extends JpaRepository<Cycle, String>{
	public Cycle findByCycleName(String cycleName);

}

