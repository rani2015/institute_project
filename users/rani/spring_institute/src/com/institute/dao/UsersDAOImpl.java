package com.institute.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.institute.model.Users;
@Repository(value="usersDAO")
@Transactional
public class UsersDAOImpl implements UsersDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Users save(Users users) {
		getSessionFactory().getCurrentSession().saveOrUpdate(users);
		System.out.println("Users saved :  "+users);
		return users;
	}

	@Override
	public Users getById(int usersId) {
		System.out.println("Users getting  :  "+usersId);
		return (Users)getSessionFactory().getCurrentSession().get(Users.class, usersId);
	}

	@Override
	public void delete(Users users) {
		System.out.println("Deleting Users "+users);
		Query query=getSessionFactory().getCurrentSession().createSQLQuery("delete from Users where id=:id");
		
		query.setInteger("id", users.getId());
		query.executeUpdate();
		
	}

	@Override
	public List<Users> findAll() {
		
		return getSessionFactory().getCurrentSession().createQuery("from Users s").list();
	}

}
