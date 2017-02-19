package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entites.Role;
import entites.User;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Query;

public class UserDAO implements Serializable {

    private static EntityManagerFactory emf = EMF.createEntityManagerFactory();

    public static User findUserByCode(String code) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select u from User u where u.code=:code");
        query.setParameter("code", code);
        User user = (User) query.getSingleResult();
        em.close();
        return user;

    }

    public static List<Role> findRolesByCode(String code) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select r from User u,in(u.roles)r where u.code=:code");
        query.setParameter("code", code);
        List<Role> roles = query.getResultList();
        em.close();
        return roles;

    }

}
