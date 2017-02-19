package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.persistence.*;

/**
 *
 * @author 0576
 */
public class EMF {

    private static EntityManagerFactory emf = null;

    public static EntityManagerFactory createEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ManagementSystemPU");
        }
        return emf;
    }
}
