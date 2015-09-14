package com.institute.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.institute.model.Trainee;
@Repository(value="traineeDAO")
@Transactional
public class TraineeDAOImpl implements TraineeDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Trainee save(Trainee trainee) {
		getSessionFactory().getCurrentSession().saveOrUpdate(trainee);
	//	Query query=getSessionFactory().getCurrentSession().createSQLQuery("insert into Trainee (CREATE_DATE, experience, note, PREV_COMPANY, skill, UPDATE_DATE, TRAINEE_ID, id) values (?, ?, ?, ?, ?, ?, ?, select TRAINEE_SEQ.nextval from dual)");
		System.out.println("Trainee saved :  "+trainee);
		return trainee;
	}

//	@Override
//	public List<Trainee> getByTraineeId(int traineeId) {
//		System.out.println("Trainee getting  :  "+traineeId);
//		Query query= getSessionFactory().getCurrentSession().createSQLQuery("SELECT * FROM TRAINEE WHERE TRAINEE_ID=:traineeId ");
//		query.setInteger("traineeId",traineeId);
//		
//		return (List<Trainee>)query.list();
//	}
	@Override
	public Trainee getByTraineeId(int traineeId) {
		System.out.println("Trainee getting  :  "+traineeId);
		Query query= getSessionFactory().getCurrentSession().createSQLQuery("SELECT * FROM TRAINEE WHERE TRAINEE_ID=:traineeId ");
		query.setInteger("traineeId",traineeId);
		
		return (Trainee)query.list().get(0);
	}
	@Override
	public Trainee getById(int id) {
		System.out.println("Trainee getting  :  "+id);
		return (Trainee)getSessionFactory().getCurrentSession().get(Trainee.class, id);
	}

	@Override
	public void delete(Trainee trainee) {
		
		System.out.println("Deleting Trainee "+trainee);
		Query query=getSessionFactory().getCurrentSession().createSQLQuery("DELETE FROM TRAINEE WHERE TRAINEE_ID=:id");
		
		query.setInteger("id", trainee.getTraineeId());
		query.executeUpdate();
	}

	@Override
	public List<Trainee> findAll() {
		
		return getSessionFactory().getCurrentSession().createQuery("from Trainee ").list();
	}

}
