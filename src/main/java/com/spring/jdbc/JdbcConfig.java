package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
public class JdbcConfig {
	
	@Bean("dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dataSource.setUsername("root");
		dataSource.setPassword("Ahnaf@1603048");
		
		return dataSource;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		
		JdbcTemplate template = new JdbcTemplate();
		
		template.setDataSource(getDataSource());
		
		return template;
	}
	
	@Bean("studentDao")
	public StudentDao getStudentDao() {
		StudentDaoImpl studentDao = new StudentDaoImpl();
		studentDao.setJdbcTemplate(getJdbcTemplate());
		
		return studentDao;
	}

}
