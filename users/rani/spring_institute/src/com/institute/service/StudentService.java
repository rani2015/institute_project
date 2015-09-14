package com.institute.service;

import java.util.List;

import com.institute.model.Trainee;

public interface StudentService {
public Trainee saveStudent(Trainee student);
public Trainee getStudentById(int studentId);
public Trainee deleteStudent(Trainee student);
public List<Trainee> listAllStudent();
}
