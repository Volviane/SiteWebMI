package com.mi.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mi.model.Article;
import com.mi.model.Dissertation;
import com.mi.model.Document;
import com.mi.model.Teacher;

public interface DocumentRepository extends JpaRepository<Document, String> {
	
	
	public Document findByDocumentTitle(String documentTitle);
	public Document findByDocumentType(String documentType);
	public List<Document> findByAuthor(Teacher author);
	public List<Document> findByAuthorAndDocumentType(Teacher author , String documentType);
	public Document findByDocumentName(String documentName);
	public Page<Document> findAll(Pageable peageble);
	public List<Document> findBydocumentTypeAndAuthor(String documentType, Teacher author);
	public long countByDocumentType(String documentType); 
	public Document findByIdDocument(Long idDocument);
	
}
