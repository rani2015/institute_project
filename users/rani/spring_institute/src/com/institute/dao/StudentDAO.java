package com.institute.dao;

import java.util.List;

import com.institute.model.Student;

public interface StudentDAO {
public Student save(Student student);
public Student getById(int studentId);
public Student delete(Student student);
public List<Student> findAll();
}
