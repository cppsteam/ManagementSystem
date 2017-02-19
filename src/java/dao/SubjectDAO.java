/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entites.*;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author 0576
 */
public class SubjectDAO implements Serializable {

    private static EntityManagerFactory emf = EMF.createEntityManagerFactory();

    public static Subject findSubjectByName(String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select s from Subject s where s.name=:name");
        query.setParameter("name", name);
        Subject subject = (Subject) query.getSingleResult();
        em.close();
        return subject;
    }
        public static List<String> findAllSubjectNames() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select s.name from Subject s");
        List<String> subjectNames = query.getResultList();
        em.close();
        return subjectNames;

    }
}
