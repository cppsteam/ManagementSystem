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
 * @author chenpeipei
 */
public class CourseTrainingPlanDAO implements Serializable {

    private static EntityManagerFactory emf = EMF.createEntityManagerFactory();

    public static List<CourseTrainingPlan> findAllCourseTrainingPlans() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select c from CourseTrainingPlan c");
        List<CourseTrainingPlan> courseTrainingPlans = query.getResultList();
        em.close();
        return courseTrainingPlans;

    }
    public static void addCourseTrainingPlan(CourseTrainingPlan courseTrainingPlan) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(courseTrainingPlan);
        em.getTransaction().commit();
        em.close();
    }
    public static void updateCourseTrainingPlan(CourseTrainingPlan courseTrainingPlan) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(courseTrainingPlan);
        em.getTransaction().commit();
        em.close();
    }
    public static void deleteCourseTrainingPlan(CourseTrainingPlan courseTrainingPlan) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (!em.contains(courseTrainingPlan)) {
            courseTrainingPlan = em.merge(courseTrainingPlan);
        }
        em.remove(courseTrainingPlan);
        em.getTransaction().commit();
        em.close();
    }
    
}
