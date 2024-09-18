package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Student;

public interface StudentDao {
	
	public int create(Student student);
	
	public int alter(Student student);
	
	public Student getStudent(int id);
}
