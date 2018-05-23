package com.mi.model;

public class Article {
	private int articleId;
	private String articleTitle;
	private String articleAbstract;
	private String articleName;
	private String articleKeywords;
	private int userId;
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	



	public Article(int articleId, String articleTitle, String articleAbstract, String articleName,
			String articleKeywords, int userId) {
		super();
		this.articleId = articleId;
		this.articleTitle = articleTitle;
		this.articleAbstract = articleAbstract;
		this.articleName = articleName;
		this.articleKeywords = articleKeywords;
		this.userId = userId;
	}



	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}




	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleAbstract() {
		return articleAbstract;
	}

	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}



	public String getArticleKeywords() {
		return articleKeywords;
	}



	public void setArticleKeywords(String articleKeywords) {
		this.articleKeywords = articleKeywords;
	}



	@Override
	public String toString() {
		return "Id de l'Article:" + articleId + "\n Titre de l'article:" + articleTitle + "\n"
				+ " R�sum�="+ articleAbstract + "\n Code =" + articleName + "\n"
						+ " Mots cl�s:" + articleKeywords+"\n Utilisateur: "+userId;
	}

	
	
	
	
	
	
	
}
