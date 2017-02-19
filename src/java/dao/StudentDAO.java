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
public class StudentDAO implements Serializable {

    private static EntityManagerFactory emf = EMF.createEntityManagerFactory();

    public static void addStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public static void deleteStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (!em.contains(student)) {
            student = em.merge(student);
        }
        em.remove(student);
        em.getTransaction().commit();
        em.close();
    }

    public static void updateStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

    public static Student findStudentByCode(String code) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select s from Student s where s.code=:code");
        query.setParameter("code", code);
        Student student = (Student) query.getSingleResult();
        em.close();
        return student;
    }

    public static List<String> findAllCodes() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select s.code from Student s");
        List<String> codes = query.getResultList();
        em.close();
        return codes;
    }
}
