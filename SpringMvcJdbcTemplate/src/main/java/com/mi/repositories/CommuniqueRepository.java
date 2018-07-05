package com.mi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Communique;

public interface CommuniqueRepository extends JpaRepository<Communique, Long>{
	public Communique findByCommuniqueTitle(String communiqueTitle);
	public Communique findByIdCommunique(Long id);
	public List<Communique> findAllOrderByPublicationDateDesc();
	public Communique findFirstOrderByPublicationDateDesc();
}
