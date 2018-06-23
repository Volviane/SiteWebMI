package com.mi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Article")
//@Table(name="ARTICLES")
@DiscriminatorValue("ARTICLE")
public class Article extends Document implements Serializable{
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="ID_ARTICLE")
//	private int articleId;
/*	
	@Column(name="TITRE_ARTICLE")
	private String articleTitle;
	private String articleAbstract;
	private String articleName;
	private String articleKeywords;*/
	
	
	
	/**
	 * 
	 */
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		
	
	
	
}
