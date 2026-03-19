package com.cg.dto;

import com.cg.entity.Trainee;

public class EntityMapper {
	public static Trainee convertObjectToEntity(TraineeDTO trdto) {
		return new Trainee(trdto.getName(),trdto.getDomain(),trdto.getLocation());
	}
    public static TraineeDTO convertEntitytoDto(Trainee t) {
    	return new TraineeDTO(t.getTraineeId(),t.getTraineeName(),t.getTraineeDomain(),t.getTraineeLocation());
    }
}
