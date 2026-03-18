package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Employee;
@Repository
public interface IEmployeeRepo extends JpaRepository<Employee,Integer> {
public List<Employee>findByName(String name);
}
