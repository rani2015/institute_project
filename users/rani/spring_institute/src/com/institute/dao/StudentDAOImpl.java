package com.institute.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.institute.model.Student;
@Repository(value="studentDAO")
@Transactional
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Student save(Student student) {
		getSessionFactory().getCurrentSession().saveOrUpdate(student);
		System.out.println("Student saved :  "+student);
		return student;
	}

	@Override
	public Student getById(int studentId) {
		System.out.println("Student getting  :  "+studentId);
		return (Student)getSessionFactory().getCurrentSession().get(Student.class, studentId);
	}

	@Override
	public Student delete(Student student) {
		
		return (Student)getSessionFactory().getCurrentSession().get(Student.class, student.getStudentId());
	}

	@Override
	public List<Student> findAll() {
		
		return getSessionFactory().getCurrentSession().createQuery("from Student s").list();
	}

}
