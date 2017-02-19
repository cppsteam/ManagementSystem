/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

/**
 *
 * @author 0576
 */
@Entity
@Table(name = "courseTrainingPlan")
public class CourseTrainingPlan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "courseTrainingPlan")
    @TableGenerator(name = "courseTrainingPlan",
            table = "generator",
            pkColumnName = "generator_name",
            valueColumnName = "generator_value",
            pkColumnValue = "courseTraining_id",
            allocationSize = 1)
    private int id;
    private String semester;
    private String examType;
    private String roomType;
    private int totalHour;
    private int theoryHour;
    private int computerHour;
    private int experimentHour;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "trainingPlan_id")
    private TrainingPlan trainingPlan;

    public CourseTrainingPlan() {

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
    
    public Course getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
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
     * @return the examType
     */
    public String getExamType() {
        return examType;
    }

    /**
     * @param examType the examType to set
     */
    public void setExamType(String examType) {
        this.examType = examType;
    }

    /**
     * @return the roomType
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * @param roomType the roomType to set
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    /**
     * @return the totalHour
     */
    public int getTotalHour() {
        return totalHour;
    }

    /**
     * @param totalHour the totalHour to set
     */
    public void setTotalHour(int totalHour) {
        this.totalHour = totalHour;
    }

    /**
     * @return the semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * @return the theoryHour
     */
    public int getTheoryHour() {
        return theoryHour;
    }

    /**
     * @param theoryHour the theoryHour to set
     */
    public void setTheoryHour(int theoryHour) {
        this.theoryHour = theoryHour;
    }

    /**
     * @return the computerHour
     */
    public int getComputerHour() {
        return computerHour;
    }

    /**
     * @param computerHour the computerHour to set
     */
    public void setComputerHour(int computerHour) {
        this.computerHour = computerHour;
    }

    /**
     * @return the experimentHour
     */
    public int getExperimentHour() {
        return experimentHour;
    }

    /**
     * @param experimentHour the experimentHour to set
     */
    public void setExperimentHour(int experimentHour) {
        this.experimentHour = experimentHour;
    }

}
