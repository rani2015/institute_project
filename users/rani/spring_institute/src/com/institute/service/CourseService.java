package com.institute.service;

import java.util.List;

import com.institute.model.Course;

public interface CourseService {
public Course saveCourse(Course course);
public Course getCourseById(String courseId);
public Course deleteCourse(Course course);
public List<Course> listAllCourse();
}
