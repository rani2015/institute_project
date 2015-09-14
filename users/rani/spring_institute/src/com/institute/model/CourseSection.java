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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Course_Section")
public class CourseSection implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
//	private int courseId;
//	private int sectionId;
	
	private String status;
	
	
	private Course course;
	private Section section;
	/*
	 * private int createdId;
	 * 
	 * private int updatedId;
	 */
	
	private Date createDate;
	
	private Date updateDate;
	

	public CourseSection(){}
	
	
	public CourseSection(Course course, Section section, String status) {
		
		this.course = course;
		this.section = section;
		this.status = status;
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	
	
//	@Column(name="SECTION_ID" , nullable=false)
//	public int getSectionId() {
//		return sectionId;
//	}
//
//	public void setSectionId(int sectionId) {
//		this.sectionId = sectionId;
//	}

	/*@Column(name="COURSE_ID" , nullable=false)
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "my_coursesection_seq")
	@SequenceGenerator(name = "my_coursesection_seq", sequenceName = "COURSE_SECTION_SEQ")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "COURSE_ID",referencedColumnName="COURSE_ID")
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SECTION_ID" ,referencedColumnName="ID")
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public String toString() {
		return "CourSection[courseId :" + course.getCourseId() + ", sectionId :" + section.getId() + "]";
	}

}
