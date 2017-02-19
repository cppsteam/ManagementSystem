/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entites.*;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author 0576
 */
public class ClassesDAO implements Serializable {

    private static EntityManagerFactory emf = EMF.createEntityManagerFactory();

    public static List<Classes> findAllClasses() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select c from Classes c");
        List<Classes> classes = query.getResultList();
        em.close();
        return classes;

    }
        public static List<String> findAllClassesNames() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select c.name from Classes c");
        List<String> classNames = query.getResultList();
        em.close();
        return classNames;

    }

    public static Classes findClassesByName(String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select c from Classes c where c.name=:name");
        query.setParameter("name", name);
        Classes classes = (Classes) query.getSingleResult();
        em.close();
        return classes;

    }
}
