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

/**
 *
 * @author 0576
 */
public class TeacherDAO implements Serializable {

    private static EntityManagerFactory emf = EMF.createEntityManagerFactory();

    public static List<Teacher> findAllTeachers() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select t from Teacher t");
        List<Teacher> teachers = query.getResultList();
        em.close();
        return teachers;

    }

    public static List<String> findAllTeacherNames() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select t.name from Teacher t");
        List<String> teacherNames = query.getResultList();
        em.close();
        return teacherNames;

    }

    public static Teacher findTeacherByName(String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select t from Teacher t where t.name=:name");
        query.setParameter("name", name);
        Teacher teacher = (Teacher) query.getSingleResult();
        em.close();
        return teacher;

    }
    public static void updateTeacher(Teacher teacher) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(teacher);
        em.getTransaction().commit();
        em.close();
    }
    public static void addTeacher(Teacher teacher) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
        em.close();
    }
    public static void deleteTeacher(Teacher teacher) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (!em.contains(teacher)) {
            teacher = em.merge(teacher);
        }
        em.remove(teacher);
        em.getTransaction().commit();
        em.close();
    }
       public static Teacher findTeacherByCode(String code) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select t from Teacher t where t.code=:code");
        query.setParameter("code", code);
        Teacher teacher = (Teacher) query.getSingleResult();
        em.close();
        return teacher;
    }
}
