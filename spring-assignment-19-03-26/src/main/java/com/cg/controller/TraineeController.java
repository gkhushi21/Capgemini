package com.cg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.TraineeDTO;
import com.cg.entity.Trainee;
import com.cg.service.ITraineeService;

@RestController
@RequestMapping("trainees")
public class TraineeController {
	
public ITraineeService service;

public TraineeController(ITraineeService service) {
	this.service= service;
}
@GetMapping
public List<TraineeDTO>getTrainee(){
	return service.getAllTrainee();
}
@GetMapping("/name/{name}")
public List<TraineeDTO>getTranbyName(@PathVariable String name){
	return service.getTraineeByName(name);
}
@GetMapping("{tid}")
public ResponseEntity<TraineeDTO> getTraineeById(@PathVariable int tid){
    TraineeDTO t= service.getTraineeById(tid);
    if(t==null){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }else {
        return new ResponseEntity<>(t, HttpStatus.OK);
    }
}
@PostMapping
public TraineeDTO createNewTrainee(@RequestBody TraineeDTO tran) {
	return service.createTrainee(tran);
}
@DeleteMapping("/{tid}")
public String delTrainee(@PathVariable int tid) {
	return service.removeTraineeDTO(tid);
}
@PutMapping
public TraineeDTO updateTrainee(@RequestBody TraineeDTO tran) {
	return service.updateTrainee(tran);
}
}
