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
public class CourseDAO implements Serializable {

    private static EntityManagerFactory emf = EMF.createEntityManagerFactory();

    public static List<Course> findCourseByType(String type,String property) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select c from Course c where c.type=:type and c.property=:property");
        query.setParameter("type", type);
        query.setParameter("property", property);
        List<Course> courses = query.getResultList();
        em.close();
        return courses;

    }
    public static List<String> findAllCourseNames() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select c.name from Course c");
        List<String> courseNames = query.getResultList();
        em.close();
        return courseNames;

    }
    public static void addCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }
    public static void updateCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(course);
        em.getTransaction().commit();
        em.close();
    }
    public static void deleteCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (!em.contains(course)) {
            course = em.merge(course);
        }
        em.remove(course);
        em.getTransaction().commit();
        em.close();
    }
}
