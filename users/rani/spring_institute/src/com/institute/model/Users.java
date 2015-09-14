package com.institute.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Users implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private int id;
	
	
	private String loginId;
	
	private String password;
	
	private String roleId;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private Date dateOfBirth;
	
	private String emailId;
	
	private String legalStatus;
	
	private String homeNo;
	
	private String officeNo;
	
	private String cellNo;
	
	private String hiqualification;
	
	
	
	private Date joinDate;
	
	private String note;
	/*@Column(name="CREATED_ID" , nullable=true)
	private int createdId;
	*/
	private Date createDate;
	/*@Column(name="UPDATED_ID" , nullable=true)
	private int updatedId;
	*/
	private Date updateDate;
	
	
	
	
	private String gender;
	
	private Address officeAddress;
	private Address homeAddres;
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OFFICE_ADDRESS_ID")
	public Address getOfficeAddress() {
		return officeAddress;
	}
	
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "HOME_ADDRESS_ID")
	public Address getHomeAddres() {
		return homeAddres;
	}
	
	public void setHomeAddres(Address homeAddres) {
		this.homeAddres = homeAddres;
	}
	public Users(){}
	
	
	public Users( String loginId, String password, String roleId,
			String firstName, String lastName, Date dateOfBirth,
			String emailId, Address officeAddress, Address homeAddres) {
		
		
		this.loginId = loginId;
		this.password = password;
		this.roleId = roleId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.officeAddress = officeAddress;
		this.homeAddres = homeAddres;
	}

	public Users( String loginId, String password, String roleId,
			String firstName, String lastName, Date dateOfBirth,
			String emailId, String gender) {
		
		
		this.loginId = loginId;
		this.password = password;
		this.roleId = roleId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.gender = gender;
	}
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO ,generator="my_users_seq")
	@SequenceGenerator(name="my_users_seq" , sequenceName="USERS_SEQ")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="LOGIN_ID" , nullable=false)
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="ROLE_ID" , nullable=false)
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	@Column(name="FIRST_NAME" , nullable=false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name="MIDDLE_NAME" , nullable=true)
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	@Column(name="LAST_NAME" , nullable=false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name="DATE_OF_BIRTH" , nullable=false)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Column(name="EMAIL_ID" , nullable=false)
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Column(name="LEGAL_STATUS" , nullable=true)
	public String getLegalStatus() {
		return legalStatus;
	}
	public void setLegalStatus(String legalStatus) {
		this.legalStatus = legalStatus;
	}
	@Column(name="HOME_NO" , nullable=true)
	public String getHomeNo() {
		return homeNo;
	}
	public void setHomeNo(String homeNo) {
		this.homeNo = homeNo;
	}
	@Column(name="OFFICE_NO" , nullable=true)
	public String getOfficeNo() {
		return officeNo;
	}
	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}
	@Column(name="CELL_NO" , nullable=true)
	public String getCellNo() {
		return cellNo;
	}
	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}
	@Column(name="HI_QUALIFICATION" , nullable=true)
	public String getHiqualification() {
		return hiqualification;
	}
	public void setHiqualification(String hiqualification) {
		this.hiqualification = hiqualification;
	}
	/*@Column(name="HOME_ADDRESS_ID" , nullable=true)
	public int getHomeAddressId() {
		return homeAddressId;
	}
	public void setHomeAddressId(int homeAddressId) {
		this.homeAddressId = homeAddressId;
	}
@Column(name="OFFICE_ADDRESS_ID" , nullable=true)
	public int getOfficeAddressId() {
		return officeAddressId;
	}
	public void setOfficeAddressId(int officeAddressId) {
		this.officeAddressId = officeAddressId;
	}*/
	@Column(name="JOIN_DATE" , nullable=true)
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	/*public int getCreatedId() {
		return createdId;
	}
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
	*/
	@Column(name="CREATE_DATE" , nullable=true)
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/*public int getUpdatedId() {
		return updatedId;
	}
	public void setUpdatedId(int updatedId) {
		this.updatedId = updatedId;
	}*/
	@Column(name="UPDATE_DATE" , nullable=true)
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String toString(){
		return "users[id="+id+",loginid="+loginId+"]";
	} 
}