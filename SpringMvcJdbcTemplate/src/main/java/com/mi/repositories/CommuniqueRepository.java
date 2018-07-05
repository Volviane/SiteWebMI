package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Communique;

public interface CommuniqueRepository extends JpaRepository<Communique, String>{
	public Communique findByCommuniqueTitle(String communiqueTitle);

}
