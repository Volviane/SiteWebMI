package com.mi.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mi.model.Article;

public class ArticleDAOImpl implements ArticleDAO {

	private JdbcTemplate jdbcTemplate;

	public ArticleDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	/*@Override
	public int saveOrUpdate(Article article) {
		int ret=-1;
		System.out.println("1");
		if (article.getArticleId() > 0) {
			String sql = "UPDATE article SET ArticleTitle=?,ArticleAbstract=?,ArticleName=?,ArticleKeywords=?,"
					+ "WHERE ArticleId=?";
			try{
				jdbcTemplate.update(sql, article.getArticleTitle(),article.getArticleAbstract(),
						article.getArticleName(),article.getArticleKeywords(),article.getArticleId());
				ret= 1;
			}catch(Exception e){
				ret= 2;
				e.printStackTrace();
			}finally{
				return ret;
			}
		} else {
			String sql = "INSERT INTO article (ArticleId,ArticleTitle,ArticleAbstract, ArticleName,"
					+ " ArticleKeywords,UserId) VALUES (?, ?, ?, ?,?,?)";
			
			try{
				System.out.println(article);
				int i=jdbcTemplate.update(sql, article.getArticleId(),article.getArticleTitle(),article.getArticleAbstract(),
						article.getArticleName(),article.getArticleKeywords(),article.getUserId());
				ret= 3;
			}catch(Exception e){
				ret= 4;
				e.printStackTrace();
			}finally {
				return ret;
			}
		}
	}

	@Override
	public void delete(int articleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Article get(int articleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> list() {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public int saveOrUpdate(Article article) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int articleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Article get(int articleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
