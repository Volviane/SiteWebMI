package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mi.model.Cycle;

public interface CycleRepository extends JpaRepository<Cycle, String>{
	public Cycle findByCycleName(String cycleRole);

}
