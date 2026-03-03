package com.cg.service;



import java.util.List;
import java.util.Random;

import com.cg.bean.Employee;
import com.cg.dao.EmployeeDao;
import com.cg.dao.IEmployeeDao;

    public class EmployeeService implements IEmployeeService {
        IEmployeeDao dao=new EmployeeDao();

        @Override
        public String createEmployee(Employee emp) {
            if(emp.getName()==null || emp.getName().length()<4 || emp.getEmail()==null ) {
                return "Invalid Employee Data";
            }
            else {
                Random r=new Random();
                String empid=emp.getName().substring(0,3)+r.nextInt(1000);
                emp.setEmpid(empid);
                return dao.saveEmployee(emp);
            }
        }

        @Override
        public Employee findById(String empid) {
            // TODO Auto-generated method stub

            return dao.findEmployee(empid);
        }

        @Override
        public List<Employee> getAllEmployee() {
            // TODO Auto-generated method stub
            return dao.getAll();
        }

        @Override
        public String updateEmployeeName(String empid, String name) {
            // TODO Auto-generated method stub
            if(empid!= null||name!=null) {
                return dao.updateEmployeeName(empid, name);
            }else
                return "invalid input";
        }

        @Override
        public String removeEmployee(String empid) {
            // TODO Auto-generated method stub
            if(empid!=null)
            return dao.deleteEmployee(empid);
            else
                return "invalid input";
        }


    }

