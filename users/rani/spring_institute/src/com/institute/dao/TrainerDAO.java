package com.institute.dao;

import java.util.List;

import com.institute.model.Trainer;

public interface TrainerDAO {
public Trainer save(Trainer trainer);
public Trainer getById(int id);
//public List<Trainee> getByTrainerId(int trainerId);
public Trainer getByTrainerId(int trainerId);
public void delete(Trainer trainer);
public List<Trainer> findAll();
}
