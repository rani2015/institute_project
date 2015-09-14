package com.institute.model.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.institute.dao.CourseDAO;
import com.institute.model.Course;

public class TestHibernateConnection {

	public static void main(String[] args) {
		ApplicationContext context=null;
		try{ context = new ClassPathXmlApplicationContext("spring_institute.hbm.xml");
		}catch(Exception e){System.out.println("here is exception "+e.getCause());e.printStackTrace();}
		
		CourseDAO courseDAO = (CourseDAO) context.getBean("courseDAO",CourseDAO.class);
		List<Course> courses = courseDAO.findAll();
		for (Course course : courses) {
			System.out.println(" --------------------------------------------------");
			System.out.println(course.toString());
		}
	}

}
