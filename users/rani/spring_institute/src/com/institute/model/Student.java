package com.institute.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



public class Student {
	private int studentId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private int age;
	private String phoneNo;
	private String cellNo;
	private String emailId;
	private String graduation;
	private String gender;
	
//	@ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(name="STUD_COURSE_T", 
//                joinColumns={@JoinColumn(name="S_ID")}, 
//                inverseJoinColumns={@JoinColumn(name="C_ID")})
private Set<Course> courses= new HashSet<Course>();
	
	
	public void addCourse(Course course){
	//	course.getStudents().add(this);
		getCourses().add(course);
	}
	public void removeCourse(Course course){
		getCourses().remove(course);
	}
	public Student(){}
	public Student(int studentId, String firstName, String lastName,
			Date dateOfBirth, int age, String phoneNo, String cellNo,
			String emailId, String graduation, String gender) {
		
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.phoneNo = phoneNo;
		this.cellNo = cellNo;
		this.emailId = emailId;
		this.graduation = graduation;
		this.gender = gender;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	public Student(int studentId){
		this.studentId=studentId;
	}
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCellNo() {
		return cellNo;
	}

	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGraduation() {
		return graduation;
	}

	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getInfo() {
		
		return String.format("[\n"
				+ " Student Id	:	%d\n"
				+ " FirstName	:	%s\n"
				+ " LastName	:	%s\n"
				+ " DateOfBirth	:	%tD\n"
				+ " Age		:	%d\n"
				+ " PhoneNo	:	%s\n"
				+ " CellNo		:	%s\n"
				+ " EmailId	:	%s\n"
				+ " Graduation	:	%s\n"
				+ " Gender		:	%s\n ]\n", studentId, firstName , lastName,dateOfBirth ,  age , phoneNo  , cellNo , emailId , graduation ,gender);
	}

	public String toString() {
		return "[studentId:" + studentId + " , firstName:" + firstName + " , lastName:"
				+ lastName + "]";
	}

}
