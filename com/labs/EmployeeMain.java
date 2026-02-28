package com.labs;

public class EmployeeMain {
   public static void main(String[] args) {
       EmployeeService emp1 = new EmployeeService();

       System.out.println("1. Average Salary of each Employee");
       System.out.println(emp1.CalAvgSal());

       System.out.println("\n 2. Maximum Salary Employee in Each Department");
       emp1.MaxSalbyDept();

       System.out.println("\n 3. Total Salary Per Department");
       emp1.TotalSalPerDept();

       System.out.println("\n 4. Employee Name and Salary");
       emp1.DisplayEmpNameAndSalary();

       System.out.println("\n 5. Employee Salary in Descending Order");
       emp1.SortBySalaryDescending();

    }
}
