package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mi.model.Cycle;

public interface CycleRepository extends JpaRepository<Cycle, Integer> {
	@Query("select c from Cycle c where c.idCycle=:x")
	public Cycle getCycleById(@Param("x") int id);
=======

import com.mi.model.Cycle;


public interface CycleRepository extends JpaRepository<Cycle, String>{
	public Cycle findByCycleName(String cycleRole);
>>>>>>> b645e368e843b3c89d5baa040c2f0ed62a8e0012

}
