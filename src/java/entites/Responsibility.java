package entites;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

/**
 *
 * @author 0576
 */
@Entity
@Table(name = "responsibility")
public class Responsibility implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "responsibility")
    @TableGenerator(name = "responsibility",
            table = "generator",
            pkColumnName = "generator_name",
            valueColumnName = "generator_value",
            pkColumnValue = "responsibility_id",
            allocationSize = 1)
    private int id;

    private String name;

    @OneToMany(mappedBy="responsibility")
    private Collection<ChildRespon> childRespons= new ArrayList<ChildRespon>();

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "responsibilities")
    private Collection<Role> roles = new ArrayList<Role>();

    public Responsibility() {

    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
 

    /**
     * @return the roles
     */
    public Collection<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    /**
     * @return the childRespons
     */
    public Collection<ChildRespon> getChildRespons() {
        return childRespons;
    }

    /**
     * @param childRespons the childRespons to set
     */
    public void setChildRespons(Collection<ChildRespon> childRespons) {
        this.childRespons = childRespons;
    }


}
