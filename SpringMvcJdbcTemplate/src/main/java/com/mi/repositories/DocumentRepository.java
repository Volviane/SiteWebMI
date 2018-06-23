package com.mi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mi.model.Article;
import com.mi.model.Dissertation;
import com.mi.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
	
	@Query("select document from Document document")
	List<Document> findAllDocument();
	
	@Query("select document from Article article")
	List<Article> findAllArticle();
	
	@Query("select document from Dissertation dissertation")
	List<Dissertation> findAllDissertation();
}
