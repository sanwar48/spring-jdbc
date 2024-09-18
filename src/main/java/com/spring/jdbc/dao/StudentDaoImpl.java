package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {
	
	
	private JdbcTemplate jdbcTemplate;
	
	

	@Override
	public int create(Student student) {
        
        String query = "insert into student(id, name, city) values (?, ?, ?)";
        
        int update = jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return update;
	}
	
	@Override
	public int alter(Student student) {
		String query  = "update student set name=? , city=? where id=?";
		
		int res = jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return res;
	}

	
	@Override
	public Student getStudent(int id) {
		String query = "select * from student where id=?";
		
		RowMapper<Student> rowMapper = new StudentRowMapper();
		Student res = jdbcTemplate.queryForObject(query, rowMapper, id);
		return res;
	}


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}






	
	

}
