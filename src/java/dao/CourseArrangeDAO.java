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
public class CourseArrangeDAO implements Serializable {

    private static EntityManagerFactory emf = EMF.createEntityManagerFactory();

    public static List<CourseArrange> findAllArranges() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select c from CourseArrange c");
        List<CourseArrange> courseArranges = query.getResultList();
        em.close();
        return courseArranges;

    }

    public static CourseArrange findCourseArrangesByClassCode(String classCode) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select c from CourseArrange c where c.classCode=:classCode");
        query.setParameter("classCode", classCode);
        CourseArrange courseArrange = (CourseArrange) query.getSingleResult();
        em.close();
        return courseArrange;

    }

    public static void updateCourseArrange(CourseArrange courseArrange) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(courseArrange);
        em.getTransaction().commit();
        em.close();
    }
}
