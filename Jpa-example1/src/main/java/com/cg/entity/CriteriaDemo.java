package com.cg.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

import static javax.management.Query.and;

public class CriteriaDemo {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
//        Root<Product> r = cq.from(Product.class);
//        Predicate con1 = cb.greaterThan(r.get("price"),30000);
//        Predicate con2 = cb.lessThan(r.get("price"),10000);
////       cq.select(r).where(cb.greaterThan(r.get("price"),50000));
////        cq.select(cq.from(Product.class));
////        cq.select(r).where(cb.like(r.get("name"),"h%"));
////        cq.select(r).orderBy(cq.getOrderList());
////        cq.select(r).orderBy(cb.desc(r.get("name")));
//        cq.select(r).where(cb.and (con1,con2)).orderBy(cb.asc(r.get("name")));
//        List<Product> li = em.createQuery(cq).getResultList();
//        li.forEach(p -> System.out.println(p) );
    }
}
