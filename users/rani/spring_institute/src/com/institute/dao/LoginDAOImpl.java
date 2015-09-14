package com.institute.dao;



import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.institute.model.Course;
import com.institute.model.Login;
@Repository(value="loginDAO")
@Transactional
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public boolean validate(Login user) {
		Login userVal=(Login)getSessionFactory().getCurrentSession().get(Login.class,user.getUserId());
		//User userVal=new User();
		
		boolean validUser=false;
		if(userVal!=null)
			validUser=true;
		else validUser=false;	
		//change after 
		validUser=true;
		return validUser;
	}

	

}
