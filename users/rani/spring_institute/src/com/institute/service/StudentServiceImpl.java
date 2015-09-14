package com.institute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.institute.dao.TraineeDAO;
import com.institute.model.Trainee;

@Service("studentService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class StudentServiceImpl implements StudentService {
	@Autowired
	private TraineeDAO studentDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Trainee saveStudent(Trainee student) {

		System.out.println("Student saved :  " + student);
		return studentDAO.save(student);
	}

	@Override
	public Trainee getStudentById(int studentId) {
		System.out.println("Student getting  :  " + studentId);
		return (Trainee) studentDAO.getById(studentId);
	}

	@Override
	public Trainee deleteStudent(Trainee student) {

		//return (Trainee) studentDAO.delete(student);
		return null;
	}

	@Override
	public List<Trainee> listAllStudent() {

		return studentDAO.findAll();
	}

}
