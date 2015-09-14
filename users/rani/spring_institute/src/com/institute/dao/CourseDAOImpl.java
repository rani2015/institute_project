package com.institute.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.institute.model.Course;
@Repository(value="courseDAO")
@Transactional
public class CourseDAOImpl implements CourseDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public Course save(Course course) {
		getSessionFactory().getCurrentSession().saveOrUpdate(course);
		System.out.println("Course saved :  "+course);
		return course;
	}

	@Override
	public Course getById(String courseId) {
		
		return (Course)getSessionFactory().getCurrentSession().get(Course.class,courseId);
	}

	@Override
	public Course delete(Course course) {
		System.out.println("here in delete course DAO"+course);
		 getSessionFactory().getCurrentSession().delete(course);
		 return course;
	}

	@Override
	public List<Course> findAll() {
		
		return getSessionFactory().getCurrentSession().createQuery("from Course c").list();
	}

}
