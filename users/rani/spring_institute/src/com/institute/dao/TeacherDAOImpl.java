package com.institute.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.institute.model.Teacher;
@Repository(value="teacherDAO")
@Transactional
public class TeacherDAOImpl implements TeacherDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Teacher save(Teacher teacher) {
		getSessionFactory().getCurrentSession().saveOrUpdate(teacher);
		System.out.println("Teacher saved :  "+teacher);
		return teacher;
	}

	@Override
	public Teacher getById(int teacherId) {
		System.out.println("Teacher getting  :  "+teacherId);
		return (Teacher)getSessionFactory().getCurrentSession().get(Teacher.class, teacherId);
	}

	@Override
	public Teacher delete(Teacher teacher) {
		
		return (Teacher)getSessionFactory().getCurrentSession().get(Teacher.class, teacher.getTeacherId());
	}

	@Override
	public List<Teacher> findAll() {
		
		return getSessionFactory().getCurrentSession().createQuery("from Teacher t").list();
	}

}
