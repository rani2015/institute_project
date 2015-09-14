package com.institute.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Section")
public class Section implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	
	private String name;
	@Column(nullable=true)
	private String description;
	private String status;
	private String note;
	/*
	 * private int createdId;
	 * 
	 * private int updatedId;
	 */
	@Column(nullable=true)
	private Date createDate;
	@Column(nullable=true)
	private Date updateDate;
	

	public Section(){}
	
	public Section(String name, String status) {
		this.name = name;
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	
	public String getName() {
		return name;
	}

	public void setName(String sectionName) {
		this.name = sectionName;
	}

	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO ,generator="my_section_seq")
	@SequenceGenerator(name="my_section_seq" , sequenceName="SECTION_SEQ")
	public int getId() {
		return id;
	}

	public void setId(int sectionHours) {
		this.id = sectionHours;
	}
	
	

	public String toString() {
		return "[id :" + id + ", sName :" + name + "]";
	}

}
