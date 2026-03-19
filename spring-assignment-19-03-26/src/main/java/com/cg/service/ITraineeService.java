package com.cg.service;
import java.util.List;

import com.cg.dto.TraineeDTO;

import com.cg.entity.Trainee;

public interface ITraineeService {
	public List<TraineeDTO> getAllTrainee();
	public List<TraineeDTO> getTraineeByName(String name);
	
	public TraineeDTO getTraineeById(Integer tid);
	
	public String removeTraineeDTO(Integer tid);
	
	public TraineeDTO createTrainee(TraineeDTO tr);
	
	
	public TraineeDTO updateTrainee(TraineeDTO tradto);
	
	

}
