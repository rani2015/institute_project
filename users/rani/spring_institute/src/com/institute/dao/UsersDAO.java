package com.institute.dao;

import java.util.List;

import com.institute.model.Users;

public interface UsersDAO {
	public Users save(Users users);
	public Users getById(int userId);
	public void delete(Users users);
	public List<Users> findAll();

}
