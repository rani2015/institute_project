package com.institute.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.institute.model.Trainer;
@Repository(value="trainerDAO")
@Transactional
public class TrainerDAOImpl implements TrainerDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Trainer save(Trainer trainer) {
		getSessionFactory().getCurrentSession().saveOrUpdate(trainer);
	//	Query query=getSessionFactory().getCurrentSession().createSQLQuery("insert into Trainer (CREATE_DATE, experience, note, PREV_COMPANY, skill, UPDATE_DATE, TRAINEE_ID, id) values (?, ?, ?, ?, ?, ?, ?, select TRAINEE_SEQ.nextval from dual)");
		System.out.println("Trainer saved :  "+trainer);
		return trainer;
	}

//	@Override
//	public List<Trainer> getByTrainerId(int trainerId) {
//		System.out.println("Trainer getting  :  "+trainerId);
//		Query query= getSessionFactory().getCurrentSession().createSQLQuery("SELECT * FROM TRAINEE WHERE TRAINEE_ID=:trainerId ");
//		query.setInteger("trainerId",trainerId);
//		
//		return (List<Trainer>)query.list();
//	}
	@Override
	public Trainer getByTrainerId(int trainerId) {
		System.out.println("Trainer getting  :  "+trainerId);
		Query query= getSessionFactory().getCurrentSession().createSQLQuery("SELECT * FROM TRAINEE WHERE TRAINEE_ID=:trainerId ");
		query.setInteger("trainerId",trainerId);
		
		return (Trainer)query.list().get(0);
	}
	@Override
	public Trainer getById(int id) {
		System.out.println("Trainer getting  :  "+id);
		return (Trainer)getSessionFactory().getCurrentSession().get(Trainer.class, id);
	}

	@Override
	public void delete(Trainer trainer) {
		
		System.out.println("Deleting Trainer "+trainer);
		Query query=getSessionFactory().getCurrentSession().createSQLQuery("DELETE FROM TRAINEE WHERE TRAINEE_ID=:id");
		
		query.setInteger("id", trainer.getTrainerId());
		query.executeUpdate();
	}

	@Override
	public List<Trainer> findAll() {
		
		return getSessionFactory().getCurrentSession().createQuery("from Trainer ").list();
	}

}
