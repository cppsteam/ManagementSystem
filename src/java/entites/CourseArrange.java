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
@Table(name = "courseArrange")
public class CourseArrange implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "courseArrange")
    @TableGenerator(name = "courseArrange",
            table = "generator",
            pkColumnName = "generator_name",
            valueColumnName = "generator_value",
            pkColumnValue = "courseArrange_id",
            allocationSize = 1)
    private int id;
    private String status;
    private String classCode;
    private String classTime;

    @OneToOne
    @JoinColumn(name = "teacherArrange_id")
    private TeacherArrange teacherArrange;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "times_id")
    private Times times;

    @ManyToOne
    @JoinColumn(name = "trainPlan_id")
    private TrainingPlan trainingPlan;

    @OneToMany(mappedBy = "courseArrange")
    private Collection<StdArrange> stdArranges = new ArrayList<StdArrange>();

    public CourseArrange() {

    }

    public CourseArrange(String status, String classCode) {
        this.status = status;
        this.classCode = classCode;
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
     * @return the classCode
     */
    public String getClassCode() {
        return classCode;
    }

    /**
     * @param classCode the classCode to set
     */
    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    /**
     * @return the teacherArrange
     */
    public TeacherArrange getTeacherArrange() {
        return teacherArrange;
    }

    /**
     * @param teacherArrange the teacherArrange to set
     */
    public void setTeacherArrange(TeacherArrange teacherArrange) {
        this.teacherArrange = teacherArrange;
    }

    /**
     * @return the classroom
     */
    public Classroom getClassroom() {
        return classroom;
    }

    /**
     * @param classroom the classroom to set
     */
    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    /**
     * @return the times
     */
    public Times getTimes() {
        return times;
    }

    /**
     * @param times the times to set
     */
    public void setTimes(Times times) {
        this.times = times;
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
     * @return the stdArranges
     */
    public Collection<StdArrange> getStdArranges() {
        return stdArranges;
    }

    /**
     * @param stdArranges the stdArranges to set
     */
    public void setStdArranges(Collection<StdArrange> stdArranges) {
        this.stdArranges = stdArranges;
    }

    /**
     * @return the classTime
     */
    public String getClassTime() {
        return classTime;
    }

    /**
     * @param classTime the classTime to set
     */
    public void setClassTime(String classTime) {
        this.classTime = classTime;
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
