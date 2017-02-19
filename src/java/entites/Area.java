/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author 0576
 */

@Entity
@Table(name = "area")
public class Area implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "area")
    @TableGenerator(name = "area",
            table = "generator",
            pkColumnName = "generator_name",
            valueColumnName = "generator_value",
            pkColumnValue = "area_id",
            allocationSize = 1)
    private int id;

    private String name;

    @OneToMany(mappedBy = "area")
    private Collection<Faculty> faculties = new ArrayList<Faculty>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Collection<Faculty> faculties) {
        this.faculties = faculties;
    }
}
