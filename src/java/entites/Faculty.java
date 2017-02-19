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
@Table(name = "faculty")
public class Faculty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "faculty")
    @TableGenerator(name = "faculty",
            table = "generator",
            pkColumnName = "generator_name",
            valueColumnName = "generator_value",
            pkColumnValue = "faculty_id",
            allocationSize = 1)
    private int id;
    private String code;
    private String name;

    @OneToMany(mappedBy = "faculty")
    private Collection<Subject> subjects = new ArrayList<Subject>();

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    public Faculty() {

    }

    public Faculty(String code, String name, Collection<Subject> subjects, Area area) {
        this.code = code;
        this.name = name;
        this.subjects = subjects;
        this.area = area;
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
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
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
     * @return the subjects
     */
    public Collection<Subject> getSubjects() {
        return subjects;
    }

    /**
     * @param subjects the subjects to set
     */
    public void setSubjects(Collection<Subject> subjects) {
        this.subjects = subjects;
    }

    /**
     * @return the area
     */
    public Area getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Area area) {
        this.area = area;
    }
}
