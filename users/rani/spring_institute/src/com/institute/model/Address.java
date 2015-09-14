package com.institute.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "my_address_seq")
	@SequenceGenerator(name = "my_address_seq", sequenceName = "ADDRESS_SEQ")
	private int id;
	@Column(name = "ADDR_L1", nullable = false)
	private String addressLine1;
	@Column(name = "ADDR_L2", nullable = true)
	private String addressLine2;
	@Column(name = "CITY", nullable = true)
	private String city;
	@Column(name = "STATE", nullable = true)
	private String state;
	@Column(name = "COUNTRY", nullable = true)
	private String country;
	@Column(name = "ZIPCODE", nullable = false)
	private String zipcode;

//	private Users users;
//
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "Address", cascade = CascadeType.ALL)
//	public Users getUsers() {
//		return users;
//	}
//
//	public void setUsers(Users users) {
//		this.users = users;
//	}

	public Address() {
	}

	public Address(int id, String zipcode) {

		this.id = id;
		this.zipcode = zipcode;
	}

//	public Address(int id, String zipcode, Users users) {
//
//		this.id = id;
//		this.zipcode = zipcode;
//		this.users = users;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String toString() {
		return "Address [id=" + id + ", zipcode=" + zipcode + "]";
	}

}