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
@Table(name = "subject")
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "subject")
    @TableGenerator(name = "subject",
            table = "generator",
            pkColumnName = "generator_name",
            valueColumnName = "generator_value",
            pkColumnValue = "subject_id",
            allocationSize = 1)
    private int id;
    private String code;
    private String name;

    @OneToMany(mappedBy = "subject")
    private Collection<Classes> classes = new ArrayList<Classes>();

    @OneToMany(mappedBy = "subject")
    private Collection<Teacher> teachers = new ArrayList<Teacher>();

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToOne
    @JoinColumn(name = "trainingPlan_id")
    private TrainingPlan trainingPlan;

    public Subject() {

    }

    public Subject(String code, String name) {
        this.code = code;
        this.name = name;
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
     * @return the classes
     */
    public Collection<Classes> getClasses() {
        return classes;
    }

    /**
     * @param classes the classes to set
     */
    public void setClasses(Collection<Classes> classes) {
        this.classes = classes;
    }

    /**
     * @return the faculty
     */
    public Faculty getFaculty() {
        return faculty;
    }

    /**
     * @param faculty the faculty to set
     */
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     * @return the trainingPlan
     */
    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    /**
     * @param trainingPlan the trainingPlan to set
     */
    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    /**
     * @return the teachers
     */
    public Collection<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * @param teachers the teachers to set
     */
    public void setTeachers(Collection<Teacher> teachers) {
        this.teachers = teachers;
    }

}
