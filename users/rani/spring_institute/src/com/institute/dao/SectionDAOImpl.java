package com.institute.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.institute.model.Section;
@Repository(value="sectionDAO")
@Transactional
public class SectionDAOImpl implements SectionDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public Section save(Section section) {
		getSessionFactory().getCurrentSession().saveOrUpdate(section);
		System.out.println("Section saved :  "+section);
		return section;
	}

	@Override
	public Section getById(int id) {
		
		return (Section)getSessionFactory().getCurrentSession().get(Section.class,id);
	}

	@Override
	public Section delete(Section section) {
		System.out.println("here in delete section DAO"+section);
		 getSessionFactory().getCurrentSession().delete(section);
		 return section;
	}

	@Override
	public List<Section> findAll() {
		
		return getSessionFactory().getCurrentSession().createQuery("from Section s").list();
	}

}
