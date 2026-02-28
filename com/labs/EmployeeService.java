package com.labs;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

  List<Employee> employeeList = EmployeeRepository.getEmployees();

public double CalAvgSal(){
    return employeeList.stream().mapToDouble(Employee::getSalary)
            .average().orElse(0.0);
}
public void MaxSalbyDept(){
    employeeList.stream().filter(e->e.getDepartment()!=null).collect(Collectors
            .groupingBy(e->e.getDepartment().getDepartmentName()))
            .forEach((deptName,list)->{
                 Employee maxSal = list.stream().max((e1,e2)->
                         Double.compare(e1.getSalary(), e2.getSalary()))
                         .get();

                 System.out.println(deptName + "->" + maxSal.getFirstName()+" " +
                         maxSal.getLastName()+ ":" + maxSal.getSalary());

    });
}

public void TotalSalPerDept(){
    employeeList.stream().filter(e->e.getDepartment()!=null).collect(Collectors
            .groupingBy(e->e.getDepartment().getDepartmentName())).
            forEach((deptName,list)->{
                double total = list.stream().mapToDouble(e->e.getSalary()).sum();

                System.out.println(deptName + ":" + total);
            });
}

 public void DisplayEmpNameAndSalary(){
    employeeList.stream().forEach(e->System.out.println
            (e.getFirstName() + " " + e.getLastName() + ": " + e.getSalary())
    );
 }

 public void SortBySalaryDescending(){
    employeeList.stream().sorted((e1,e2)-> Double.compare(e2.getSalary(),e1.getSalary()))
            .forEach(e->System.out.println(e.getFirstName() + " " + e.getLastName()
            + ": " + e.getSalary())
            );
 }


//    Create an EmployeeService class which queries on collections provided by EmployeeRepository class for following
//    requirements. Create separate method for each requirement. (Note: Each
//    requirement stated below must be attempted by using lambda expressions/stream
//    API.
//
//1. Calculate average salary.
//2. Find employee with maximum salary in each department.
//            3. Calculate total salary per department.
//4. Display employee name and salary.
//5. Sort by salary in descending order






}
