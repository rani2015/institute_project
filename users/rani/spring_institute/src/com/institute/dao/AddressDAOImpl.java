package com.institute.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.institute.model.Address;
@Repository(value="addressDAO")
@Transactional
public class AddressDAOImpl implements AddressDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Address save(Address address) {
		getSessionFactory().getCurrentSession().saveOrUpdate(address);
		System.out.println("Address saved :  "+address);
		return address;
	}

	@Override
	public Address getById(int addressId) {
		System.out.println("Address getting  :  "+addressId);
		return (Address)getSessionFactory().getCurrentSession().get(Address.class, addressId);
	}

	@Override
	public void delete(Address address) {
		System.out.println("Deleting Address "+address);
		Query query=getSessionFactory().getCurrentSession().createSQLQuery("delete from Address where id=:id");
		
		query.setInteger("id", address.getId());
		query.executeUpdate();
		
	}

	@Override
	public List<Address> findAll() {
		
		return getSessionFactory().getCurrentSession().createQuery("from Address s").list();
	}

}
