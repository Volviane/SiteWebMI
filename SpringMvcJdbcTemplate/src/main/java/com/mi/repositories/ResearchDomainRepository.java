package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mi.model.ResearchDomain;

public interface ResearchDomainRepository extends JpaRepository<ResearchDomain, String>{
	
	public ResearchDomain findByDomainLabel(String domainLabel);

}
