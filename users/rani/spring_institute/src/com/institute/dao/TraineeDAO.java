package com.institute.dao;

import java.util.List;

import com.institute.model.Trainee;

public interface TraineeDAO {
public Trainee save(Trainee trainee);
public Trainee getById(int id);
//public List<Trainee> getByTraineeId(int traineeId);
public Trainee getByTraineeId(int traineeId);
public void delete(Trainee trainee);
public List<Trainee> findAll();
}
