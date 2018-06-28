package com.mi.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mi.dao.ArticleDAO;
import com.mi.dao.ArticleDAOImpl;
import com.mi.dao.ContactDAO;
import com.mi.dao.ContactDAOImpl;
import com.mi.dao.StudentDAO;
import com.mi.dao.StudentDAOImpl;
import com.mi.dao.TeacherDAO;
import com.mi.dao.TeacherDAOImpl;
import com.mi.model.Article;

@PropertySource(value={"classpath:application.properties"})
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.mi")
@EnableWebMvc
@EnableJpaRepositories("com.mi.repositories")
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Autowired
	Environment env;
	
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver createMultipartResolver() {
	    CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	    resolver.setDefaultEncoding("utf-8");
	    resolver.setMaxUploadSize(999999999);
	    return resolver;
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/", "/resources/userResources/css");
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.userName"));
		dataSource.setPassword(env.getProperty("db.userPassword")); 	
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
		
		System.out.println("hummmmm");
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		System.out.println("hummmmm1");
		factoryBean.setDataSource(getDataSource());
		System.out.println("hummmmm2");
		factoryBean.setPackagesToScan(new String[] { "com.mi.model" });
		System.out.println("hummmmm3");
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		System.out.println("hummmmm4");
		factoryBean.setJpaProperties(jpaProperties());
		System.out.println("hummmmm5");
	return factoryBean;
	}
	
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		System.out.println("vendo");
		return hibernateJpaVendorAdapter;
	}

	 
	/*
	 * Here you can specify any provider specific properties.
	 */
	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		System.out.println("vendo1");
		properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		System.out.println("vendo2");
		properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		System.out.println("vendo3");
		return properties;
	}

	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		System.out.println("tran0");
		txManager.setEntityManagerFactory(emf);
		System.out.println("tran1");
		return txManager;
	}

	
	@Bean
	public ContactDAO getContactDAO() {
		return new ContactDAOImpl(getDataSource());
	}
	@Bean
	public StudentDAO getStudentDAO() {
		return new StudentDAOImpl(getDataSource());
	}
	
	@Bean
	public TeacherDAO getTeacherDAO(){
		return new TeacherDAOImpl(getDataSource());
	}
	@Bean
	public ArticleDAO getArticleDao(){
		return new ArticleDAOImpl(getDataSource());
	}
}
