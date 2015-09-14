package com.institute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.institute.dao.LoginDAO;
import com.institute.model.Login;
import com.institute.validation.UserAuthentication;




@Service("loginService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAO loginDAO;

	@Override
	public boolean validateUser(Login user) {
		boolean isValid=false;
		if (UserAuthentication.validateUser(user.getUserId(), user.getPassword())) {
			isValid = true;
		}
		
		return isValid;
	}

	@Override
	public boolean logoutUser(Login user) {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
