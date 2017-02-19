/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Table;

/**
 *
 * @author 0576
 */
@Entity
@Table(name = "stdArrange")
public class StdArrange  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "stdArrange")
    @TableGenerator(name = "stdArrange",
            table = "generator",
            pkColumnName = "generator_name",
            valueColumnName = "generator_value",
            pkColumnValue = "stdArrange_id",
            allocationSize = 1)
    private int id;
    private double ordinaryScore;
    private double testScore;
    private double totalScore;
    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "courseArrange_id")
    private CourseArrange courseArrange;

    public StdArrange() {
    }

    public StdArrange(double ordinaryScore, double testScore, double totalScore, String status, Student student, CourseArrange courseArrange) {
        this.ordinaryScore = ordinaryScore;
        this.testScore = testScore;
        this.totalScore = totalScore;
        this.status = status;
        this.student = student;
        this.courseArrange = courseArrange;
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
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * @return the courseArrange
     */
    public CourseArrange getCourseArrange() {
        return courseArrange;
    }

    /**
     * @param courseArrange the courseArrange to set
     */
    public void setCourseArrange(CourseArrange courseArrange) {
        this.courseArrange = courseArrange;
    }

    /**
     * @return the ordinaryScore
     */
    public double getOrdinaryScore() {
        return ordinaryScore;
    }

    /**
     * @param ordinaryScore the ordinaryScore to set
     */
    public void setOrdinaryScore(double ordinaryScore) {
        this.ordinaryScore = ordinaryScore;
    }

    /**
     * @return the testScore
     */
    public double getTestScore() {
        return testScore;
    }

    /**
     * @param testScore the testScore to set
     */
    public void setTestScore(double testScore) {
        this.testScore = testScore;
    }

    /**
     * @return the totalScore
     */
    public double getTotalScore() {
        return totalScore;
    }

    /**
     * @param totalScore the totalScore to set
     */
    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
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
