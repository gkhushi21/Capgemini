package com.cg.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class EmployeeMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
//        PEmployee obj = new PEmployee();
//        obj.setEnmae("khushi");
//        obj.setSalary(50000);
//          obj.setDob(LocalDate.of(2000,12,3));
//         em.persist(obj);
//         em.getTransaction().commit();
//        System.out.println("created");

        CEmployee obj = new CEmployee();
        obj.setEnmae("khushi");
       obj.setPay_per_hour(6000);
        obj.setDob(LocalDate.of(2000,12,3));
        em.persist(obj);

        System.out.println("created");
        PEmployee obj1 = new PEmployee();
        obj1.setEnmae("Raj");
        obj1.setDob(LocalDate.of(1999,10,12));
        obj1.setSalary(60000);
        em.persist(obj1);
        em.getTransaction().commit();
    }
}
