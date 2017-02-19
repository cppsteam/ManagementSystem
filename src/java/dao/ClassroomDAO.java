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
public class ClassroomDAO  implements Serializable {

    private static EntityManagerFactory emf = EMF.createEntityManagerFactory();

    public static List<Classroom> findAllClassroom() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select c from Classroom c");
        List<Classroom> classrooms = query.getResultList();
        em.close();
        return classrooms;

    }
    
}
