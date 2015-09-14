package com.institute.dao;

import java.util.List;

import com.institute.model.Address;

public interface AddressDAO {
	public Address save(Address address);
	public Address getById(int id);
	public void delete(Address address);
	public List<Address> findAll();

}
