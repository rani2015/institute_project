package com.institute.dao;

import java.util.List;

import com.institute.model.Course;

public interface CourseDAO {
public Course save(Course course);
public Course getByCourseId(String courseId);
public Course getById(int courseId);
public Course delete(Course course);
public List<Course> findAll();
}
