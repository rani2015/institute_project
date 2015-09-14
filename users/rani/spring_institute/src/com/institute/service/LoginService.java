package com.institute.service;

import com.institute.model.Login;



public interface LoginService {

	boolean validateUser(Login user);

	boolean logoutUser(Login user);

}
