package com.institute.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "Trainee")
public class Trainee implements Serializable {

	private static final long serialVersionUID = 1L;
	//private int id;

	private int traineeId;
	private Users user;
	
	private String skill;
	
	private String experience;
	
	private String prevCompany;
	
	private String note;
	/*@Column(name="CREATEDID" , nullable=true)
	private int createdId;
	@Column(name="UPDATEDID" , nullable=true)
	private int updatedId;
	*/
	private Date createDate;
	
	private Date updateDate;
	
//	@Id 
//	@GeneratedValue(strategy=GenerationType.AUTO ,generator="my_trainee_seq")
//	@SequenceGenerator(name="my_trainee_seq" , sequenceName="TRAINEE_SEQ")
//	public int getId() {
//		return id;
//	}
//
//
//	public void setId(int id) {
//		this.id = id;
//	}


	@Id 
	@Column(name="TRAINEE_ID", nullable=false)
	public int getTraineeId() {
		return user.getId();
	}


	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}


	public String getSkill() {
		return skill;
	}

	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TRAINEE_ID")
	public Users getUser() {
		return user;
	}
	public Trainee(){}

	public Trainee(Users user) {
		
		this.user = user;
	}
//public Trainee(int id,Users user) {
//		this.id=id;
//		this.user = user;
//	}

	public void setUser(Users user) {
		this.user = user;
	}

	
	

	public void setSkill(String skill) {
		this.skill = skill;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
	}

	@Column(name="PREV_COMPANY" , nullable=true)
	public String getPrevCompany() {
		return prevCompany;
	}


	public void setPrevCompany(String prevCompany) {
		this.prevCompany = prevCompany;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}

/*
	public int getCreatedId() {
		return createdId;
	}


	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}*/

	@Column(name="CREATE_DATE" , nullable=true)
	
	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

/*
	public int getUpdatedId() {
		return updatedId;
	}


	public void setUpdatedId(int updatedId) {
		this.updatedId = updatedId;
	}
*/
	@Column(name="UPDATE_DATE" , nullable=true)
	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	

	@Override
	public String toString() {
		return "Trainee [traineeId=" + getTraineeId() + ", skill=" + skill + "]";
	}
	
	
}
	
	
