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
@Table(name = "role")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "role")
    @TableGenerator(name = "role",
            table = "generator",
            pkColumnName = "generator_name",
            valueColumnName = "generator_value",
            pkColumnValue = "role_id",
            allocationSize = 1)
    private int id;

    private String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "role_responsibility",
            joinColumns = {
                @JoinColumn(name = "role_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "respon_id", referencedColumnName = "id")
            })
    private Collection<Responsibility> responsibilities = new ArrayList<Responsibility>();

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "roles")
    private Collection<User> users = new ArrayList<User>();

    public Role() {

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
     * @return the position
     */
    public Collection<Responsibility> getResponsibilities() {
        return responsibilities;
    }

    /**
     * @param position the position to set
     */
    public void setResponsibilities(Collection<Responsibility> responsibilities) {
        this.responsibilities = responsibilities;
    }
}
