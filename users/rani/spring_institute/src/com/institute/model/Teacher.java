package com.institute.model;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
	private int teacherId;
	private String teacherFirstName;
	private String teacherLastName;
	private String teacherPhoneNo;
	private String teacherCellNo;
	private String teacherEmailId;
	public Teacher(){}
	
	public Teacher(int teacherId, String teacherFirstName,
			String teacherLastName, String teacherPhoneNo,
			String teacherCellNo, String teacherEmailId) {
		super();
		this.teacherId = teacherId;
		this.teacherFirstName = teacherFirstName;
		this.teacherLastName = teacherLastName;
		this.teacherPhoneNo = teacherPhoneNo;
		this.teacherCellNo = teacherCellNo;
		this.teacherEmailId = teacherEmailId;
	}

	private Set<Course> teachCourses =new HashSet<Course>();
	
	public void addCourse(Course course){
	//	course.getTeachers().add(this);
		teachCourses.add(course);
	}
	public void removeCourse(Course course){
		teachCourses.remove(course);
	}
	
	public int getTeacherId() {
		return teacherId;
	}

	public Set<Course> getTeachCourses() {
		return teachCourses;
	}

	public void setTeachCourses(Set<Course> teachCourses) {
		this.teachCourses = teachCourses;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherFirstName() {
		return teacherFirstName;
	}

	public void setTeacherFirstName(String teacherFistName) {
		this.teacherFirstName = teacherFistName;
	}

	public String getTeacherLastName() {
		return teacherLastName;
	}

	public void setTeacherLastName(String teacherLastName) {
		this.teacherLastName = teacherLastName;
	}

	public String getTeacherPhoneNo() {
		return teacherPhoneNo;
	}

	public void setTeacherPhoneNo(String teacherPhoneNo) {
		this.teacherPhoneNo = teacherPhoneNo;
	}

	public String getTeacherCellNo() {
		return teacherCellNo;
	}

	public void setTeacherCellNo(String teacherCellNo) {
		this.teacherCellNo = teacherCellNo;
	}

	public String getTeacherEmailId() {
		return teacherEmailId;
	}

	public void setTeacherEmailId(String teacherEmailId) {
		this.teacherEmailId = teacherEmailId;
	}

		public String getInfo() {
		return String.format(" teacherId:%d\n" + "teacherFirstName	:%s\n"
				+ "teacherLastName	:%s\n" + "teacherPhoneNo	:%s\n" + "teacherCellNo	:%s\n"
				+ "teacherEmailId	:%s\n", teacherId, teacherFirstName, teacherLastName, teacherPhoneNo,
				teacherCellNo, teacherEmailId);
	}

	public String toString() {
		return "[teachId :" + teacherId + ", teachName :" + teacherFirstName + "]";
	}

}
