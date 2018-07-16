package com.mi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mi.model.Level;
import com.mi.model.Result;
import com.mi.model.Teacher;

public interface ResultRepository extends JpaRepository<Result, Long>{
	
	@Query("select r from Result r where r.resultTitle like :x")
	public List<Result> findResult(@Param("x") String mc);
	
	public Result findByResultTitle(String resultTitle);
	public List<Result> findByResultTitleAndJury_JuryPresident(String resultTitle, Teacher teacher);
	public List<Result> findByJury_JuryPresident(Teacher teacher);
	public List<Result> findByJury_JuryLevel(Level level);
	public List<Result> findByIsPublish(boolean isPublish);
	public Result findByIdResult(Long idResult);

}
