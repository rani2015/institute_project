package com.institute.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.institute.model.CourseSection;
@Repository(value="courseSectionDAO")
@Transactional
public class CourseSectionDAOImpl implements CourseSectionDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public CourseSection save(CourseSection courseSection) {
		getSessionFactory().getCurrentSession().saveOrUpdate(courseSection);
		System.out.println("CourseSection saved :  "+courseSection);
		return courseSection;
	}

	@Override
	public CourseSection getById(int id) {
		
		return (CourseSection)getSessionFactory().getCurrentSession().get(CourseSection.class,id);
	}

	@Override
	public CourseSection delete(CourseSection courseSection) {
		System.out.println("here in delete courseSection DAO"+courseSection);
		 getSessionFactory().getCurrentSession().delete(courseSection);
		 return courseSection;
	}

	@Override
	public List<CourseSection> findAll() {
		
		return getSessionFactory().getCurrentSession().createQuery("from CourseSection s").list();
	}

}
