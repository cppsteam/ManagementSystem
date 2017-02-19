package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entites.Responsibility;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 *
 * @author 0576
 */
public class ResponsibilityDAO implements Serializable {

    private static EntityManagerFactory emf = EMF.createEntityManagerFactory();

    public static List<Responsibility> findResponsByCode(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select from Role r,in(r.responsibilities)res where r.id=:id");
        query.setParameter("id", id);
        List<Responsibility> responsibilities = query.getResultList();
        em.close();
        return responsibilities;

    }
}
