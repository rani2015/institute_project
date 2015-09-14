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
@Table(name = "Trainer")
public class Trainer implements Serializable {

	private static final long serialVersionUID = 1L;
	//private int id;

	
	
	private int trainerId;
	private Users user;
	
	private int courseSecId;
	
	private int fee;
	
	
	
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
	@Column(name="TRAINER_ID", nullable=false)
	public int getTrainerId() {
		return user.getId();
	}


	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}


	public int getFee() {
		return fee;
	}

	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TRAINER_ID")
	public Users getUser() {
		return user;
	}
	public Trainer(){}

	public Trainer(Users user) {
		
		this.user = user;
	}
//public Trainee(int id,Users user) {
//		this.id=id;
//		this.user = user;
//	}

	public void setUser(Users user) {
		this.user = user;
	}

	
	

	public void setFee(int fee) {
		this.fee = fee;
	}

	
	@Column(name="COURSE_SECTION_ID" , nullable=true)
	public int getCourseSecId() {
		return courseSecId;
	}


	public void setCourseSecId(int courseSecId) {
		this.courseSecId = courseSecId;
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
		return "Trainer [trainerId=" + getTrainerId() + " ,courseSecId="+courseSecId+", fee=" + fee + "]";
	}
	
	
}
	
	
