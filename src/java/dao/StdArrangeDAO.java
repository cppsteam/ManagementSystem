/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entites.*;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author 0576
 */
public class StdArrangeDAO implements Serializable {

    private static EntityManagerFactory emf = EMF.createEntityManagerFactory();

    public static void updateStdArrange(StdArrange stdArrange) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(stdArrange);
        em.getTransaction().commit();
        em.close();
    }
}
