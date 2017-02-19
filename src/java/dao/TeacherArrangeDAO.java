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
public class TeacherArrangeDAO implements Serializable {

    private static EntityManagerFactory emf = EMF.createEntityManagerFactory();

    public static List<TeacherArrange> findTeacherArrangesByType(String type) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select t from TeacherArrange t where t.course.type=:type");
        query.setParameter("type", type);
        List<TeacherArrange> teacherArranges = query.getResultList();
        em.close();
        return teacherArranges;

    }

}
