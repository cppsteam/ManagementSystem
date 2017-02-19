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
@Table(name = "trainingPlan")
public class TrainingPlan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "trainingPlan")
    @TableGenerator(name = "trainingPlan",
            table = "generator",
            pkColumnName = "generator_name",
            valueColumnName = "generator_value",
            pkColumnValue = "trainingPlan_id",
            allocationSize = 1)
    private int id;
    private String edition;
    private String status;

    @OneToOne(mappedBy = "trainingPlan")
    private Subject subject;

    @OneToMany(mappedBy = "trainingPlan")
    private Collection<CourseTrainingPlan> courseTrainingPlans = new ArrayList<CourseTrainingPlan>();

    @OneToMany(mappedBy = "trainingPlan")
    private Collection<CourseArrange> courseArranges = new ArrayList<CourseArrange>();

    public TrainingPlan() {
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
     * @return the edition
     */
    public String getEdition() {
        return edition;
    }

    /**
     * @param edition the edition to set
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Subject getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * @return the courseTrainingPlan
     */
    public Collection<CourseTrainingPlan> getCourseTrainingPlans() {
        return courseTrainingPlans;
    }

    /**
     * @param courseTrainingPlan the courseTrainingPlan to set
     */
    public void setCourseTrainingPlans(Collection<CourseTrainingPlan> courseTrainingPlans) {
        this.courseTrainingPlans = courseTrainingPlans;
    }

    /**
     * @return the courseArranges
     */
    public Collection<CourseArrange> getCourseArranges() {
        return courseArranges;
    }

    /**
     * @param courseArranges the courseArranges to set
     */
    public void setCourseArranges(Collection<CourseArrange> courseArranges) {
        this.courseArranges = courseArranges;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
