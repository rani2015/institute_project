package com.institute.model;

import java.util.HashSet;
import java.util.Set;

public class Course {
	private String courseName;
	private double courseFee;
	private int courseHours;
	private String courseId;
	//@ManyToMany(mappedBy="courses")
	private Set<Trainee> students=new HashSet<Trainee>();
	private Set<Teacher> teachers=new HashSet<Teacher>();
	
	
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
/*public void addStudent(Student stud){
		stud.getCourses().add(this);
		getStudents().add(stud);
	}
	public void removeCourse(Student stud){
		getStudents().remove(stud);
	}*/
public Course(){}
	public Course(String courseId,String courseName, double courseFee, int courseHours) {
		
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.courseHours = courseHours;
		this.courseId = courseId;
	}


	public Set<Trainee> getStudents() {
		return students;
	}

	public void setStudents(Set<Trainee> students) {
		this.students = students;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}

	public int getCourseHours() {
		return courseHours;
	}

	public void setCourseHours(int courseHours) {
		this.courseHours = courseHours;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String cId) {
		this.courseId = cId;
	}

	public String getInfo() {
		return String.format("[\nCourse Id	:%s\n" + "CourseName	:%s\n"
				+ "CourseFee	:%s\n" + "CourseHours	:%s\n]\n", courseId, courseName,
				courseFee, courseHours);
	}

	public String toString() {
		return "[courseId :" + courseId + ", cName :" + courseName + "]";
	}
	

}
