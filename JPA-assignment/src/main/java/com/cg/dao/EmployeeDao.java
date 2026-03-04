package com.cg.dao;



import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.bean.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class EmployeeDao implements IEmployeeDao{
        private static EntityManager em;
        static {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
            em = emf.createEntityManager();
        }
        @Override
        public String saveEmployee(Employee emp) {
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();
            return "employee created";
        }

        @Override
        public Employee findEmployee(String empid) {
            return em.find(Employee.class,empid);

        }

        @Override
        public List<Employee> getAll() {
          Query q = em.createQuery("SELECT e from Employee e");
          List<Employee> li = q.getResultList();
          li.forEach(e-> System.out.println(e));

            return li;
        }

        @Override
        public String updateEmployeeName(Employee emp) {
            Employee e = em.find(Employee.class, emp.getEmpid());
            if (e != null) {
                em.getTransaction().begin();
                e.setName(emp.getName());
                e.setDob(emp.getDob());
                e.setEmail(emp.getEmail());
                em.getTransaction().commit();
                return "updated";
            }
            else{
                return "not updated";
            }
        }
        @Override
        public String deleteEmployee(String empid) {
            // TODO Auto-generated method stub
            Employee emp = em.find(Employee.class,empid);
            if(emp!=null){
                em.getTransaction().begin();
                em.remove(emp);
                em.getTransaction().commit();
                return "Deleted Employee";
            }
             return "Failed to delete";

        }
    }

