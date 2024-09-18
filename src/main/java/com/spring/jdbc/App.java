package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "program started....." );
        
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
//        Student student = new Student(3, "hasib", "bihar");
        
//        int res = studentDao.create(student);
        
//        int res = studentDao.alter(student);
        
        Student student = studentDao.getStudent(3);
        
//        System.out.println("line affected = " + res);
        System.out.println(student);
        
        
    }
}
