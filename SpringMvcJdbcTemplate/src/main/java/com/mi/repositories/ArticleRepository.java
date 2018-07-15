package com.mi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mi.model.Article;

public interface ArticleRepository extends JpaRepository<Article, String>{
	
	public Article findByArticleTitle(String articleTitle);


}
