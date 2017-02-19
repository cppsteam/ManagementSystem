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
public class ProvinceDAO implements Serializable {

    private static EntityManagerFactory emf = EMF.createEntityManagerFactory();

    public static List<String> findAllProvinceNames() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select p.name from Province p");
        List<String> provinces = query.getResultList();
        em.close();
        return provinces;

    }
    public static Province findProvinceByName(String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select p from Province p where p.name=:name");
        query.setParameter("name", name);
        Province province = (Province) query.getSingleResult();
        em.close();
        return province;

    }
}
