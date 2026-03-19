package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dto.TraineeDTO;
import com.cg.entity.Trainee;
@Repository
public interface ITraineeRepo extends JpaRepository<Trainee, Integer> {
public List<Trainee>findByTraineeName(String name);
}
