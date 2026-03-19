package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ITraineeRepo;
import com.cg.dto.EntityMapper;
import com.cg.dto.TraineeDTO;
import com.cg.entity.Trainee;

@Service
public class TraineeService implements ITraineeService {
	@Autowired
public ITraineeRepo trepo;
	@Override
	public List<TraineeDTO> getTraineeByName(String name) {
		// TODO Auto-generated method stub
		List<Trainee> traineeList = trepo.findByTraineeName(name);
		List<TraineeDTO> traineeDTOList = new ArrayList<>();
		for(Trainee trainee:traineeList) {
			traineeDTOList.add(EntityMapper.convertEntitytoDto(trainee));
		}
		return traineeDTOList;
		}

	@Override
	public List<TraineeDTO> getAllTrainee() {
		// TODO Auto-generated method stub
		List<Trainee> trainees = trepo.findAll();
		List<TraineeDTO> traineeDTO= new ArrayList<>();
		for(Trainee tra : trainees) {
			traineeDTO.add(EntityMapper.convertEntitytoDto(tra));
		}
		return traineeDTO;
	}

	

	

	@Override
	public TraineeDTO createTrainee(TraineeDTO tr) {
		// TODO Auto-generated method stub
		Trainee t = trepo.saveAndFlush(EntityMapper.convertObjectToEntity(tr));
		return EntityMapper.convertEntitytoDto(t);
	}

	@Override
	public TraineeDTO updateTrainee(TraineeDTO tr) {
		// TODO Auto-generated method stub
		Optional<Trainee> trainee=trepo.findById(tr.getTid());
		if(trainee.isPresent()) {
			Trainee tr1 = EntityMapper.convertObjectToEntity(tr);
			tr1.setTraineeId(tr.getTid());
			Trainee t = trepo.saveAndFlush(tr1);
			return EntityMapper.convertEntitytoDto(t);
		}
		
		return null;
	}

	
	@Override
	public TraineeDTO getTraineeById(Integer tid) {
		// TODO Auto-generated method stub
		Optional<Trainee> trainee = trepo.findById(tid);
		if(trainee.isPresent()) {
			return EntityMapper.convertEntitytoDto(trainee.get());
		}
		return null;
	}

	@Override
	public String removeTraineeDTO(Integer tid) {
		// TODO Auto-generated method stub
		Trainee t = EntityMapper.convertObjectToEntity(getTraineeById(tid));
		if(t!=null) {
			trepo.deleteById(tid);
			return "Trainee is deleted";
		}
		return "Trainee is not Present!";
	}
	

}
