/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author 0576
 */

@Entity
@Table(name = "course")
public class Course  implements Serializable{

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "course")
    @TableGenerator(name = "course",
            table = "generator",
            pkColumnName = "generator_name",
            valueColumnName = "generator_value",
            pkColumnValue = "course_id",
            allocationSize = 1)
    private int id;
    private String code;
    private String name;
    private int credit;

    private String type;
    private String property;
   

    @OneToMany(mappedBy = "course")
    private Collection<CourseTrainingPlan> courseTrainingPlans = new ArrayList<CourseTrainingPlan>();

    public Course() {

    }

    public Course(String code, String name, int credit, String type) {
        this.code = code;
        this.name = name;
        this.credit = credit;
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
     * @return the credit
     */
    public int getCredit() {
        return credit;
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Collection<CourseTrainingPlan> getCourseTrainingPlans() {
        return courseTrainingPlans;
    }

    /**
     * @param courseTrainingPlans the courseTrainingPlans to set
     */
    public void setCourseTrainingPlans(Collection<CourseTrainingPlan> courseTrainingPlans) {
        this.courseTrainingPlans = courseTrainingPlans;
    }

    /**
     * @return the property
     */
    public String getProperty() {
        return property;
    }

    /**
     * @param property the property to set
     */
    public void setProperty(String property) {
        this.property = property;
    }
}
