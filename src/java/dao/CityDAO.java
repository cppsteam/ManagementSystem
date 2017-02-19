/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entites.*;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author chenpeipei
 */
public class CityDAO implements Serializable {

    private static EntityManagerFactory emf = EMF.createEntityManagerFactory();
    
    public static City findCityByName(String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select c from City c where c.name=:name");
        query.setParameter("name", name);
        City city = (City) query.getSingleResult();
        em.close();
        return city;

    }
    
}
