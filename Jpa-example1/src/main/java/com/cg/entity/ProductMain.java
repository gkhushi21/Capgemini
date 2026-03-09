package com.cg.entity;

import jakarta.persistence.*;

import java.util.List;

public class ProductMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

//        TypedQuery<Object[]> q = em.createQuery("select p.name,p.price,p.date from Product p", Object[].class);
//
//        List<Object[]> li = q.getResultList();
//        li.forEach(p-> System.out.println(p[0] + "\t"+p[1]+"\t"+p[2]));
//        TypedQuery<ProductDTO> q = em.createQuery("select new ProductDTO(p.name,p.price,p.date) " +
//                "from Product p", ProductDTO.class);
//
//        List<ProductDTO> li = q.getResultList();
//        li.forEach(p-> System.out.println(p));

//        TypedQuery<Product> q1 = em.createQuery("select p from Product p where p.price<70000", Product.class);
//        List<Product> li = q1.getResultList();
//        li.forEach(p-> System.out.println(p));
//
//        TypedQuery<Product> q2 = em.createQuery("select p from Product p where p.name like :p", Product.class);
//        q2.setParameter("p","l%");
//        List<Product>li1 = q2.getResultList();
//        li1.forEach(p-> System.out.println(p));

//        TypedQuery<Product> q2 = em.createQuery("select p from Product p where p.price<:p", Product.class);
//        q2.setParameter("p",60000);
//        List<Product>li1 = q2.getResultList();
//        li1.forEach(p-> System.out.println(p));

        em.getTransaction().begin();
//        Query q = em.createQuery("update Product  p set p.price = 55000 where p.pid = 103 ");
//        int row = q.executeUpdate();
//        em.getTransaction().commit();
//        Query q = em.createNativeQuery("update product_table p set p.price = 50000 where p.pid = 103");
//        int row = q.executeUpdate();
//        System.out.println("updated -> "+row);
//        em.getTransaction().commit();



    }

}
