package com.mi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Result;

public interface ResultRepository extends JpaRepository<Result, String>{
	
	public Result findByResultTitle(String resultTitle);
	
	public List<Result> findByIsPublish(boolean isPublish);

}
