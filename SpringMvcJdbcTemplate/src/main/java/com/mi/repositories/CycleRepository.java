package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mi.model.Cycle;

public interface CycleRepository extends JpaRepository<Cycle, Integer> {
	@Query("select c from Cycle c where c.idCycle=:x")
	public Cycle getCycleById(@Param("x") int id);

}
