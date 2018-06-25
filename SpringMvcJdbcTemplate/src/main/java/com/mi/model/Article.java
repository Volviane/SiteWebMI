package com.mi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Article")
@Table(name="ARTICLES")
public class Article implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ARTICLE")
	private int idArticle;
	
	@Column(name="TITRE_ARTICLE")
	private String articleTitle;
	
	@Column(name="RESUME_ARTICLE")
	private String articleAbstract;
	
	@Column(name="NOM_ARTICLE")
	private String articleName;

	@ManyToOne
	private Student author;
	
	@OneToOne(mappedBy="studentArticle")
	private Participation participation;
	
	
	/**
	 * 
	 */
	public Article() {
		super();
		
	}



	/**
	 * @return the idArticle
	 */
	public int getIdArticle() {
		return idArticle;
	}



	/**
	 * @param idArticle the idArticle to set
	 */
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}



	/**
	 * @return the articleTitle
	 */
	public String getArticleTitle() {
		return articleTitle;
	}



	/**
	 * @param articleTitle the articleTitle to set
	 */
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}



	/**
	 * @return the articleAbstract
	 */
	public String getArticleAbstract() {
		return articleAbstract;
	}



	/**
	 * @param articleAbstract the articleAbstract to set
	 */
	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}



	/**
	 * @return the articleName
	 */
	public String getArticleName() {
		return articleName;
	}



	/**
	 * @param articleName the articleName to set
	 */
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}



	/**
	 * @return the author
	 */
	public Student getAuthor() {
		return author;
	}



	/**
	 * @param author the author to set
	 */
	public void setAuthor(Student author) {
		this.author = author;
	}
	
		
	
	
	
}
