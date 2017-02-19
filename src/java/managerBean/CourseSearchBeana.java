/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entites.*;
import java.util.*;
import javax.faces.bean.*;

/**
 *
 * @author 0576
 */
@ManagedBean
@RequestScoped
public class CourseSearchBeana {

    private String facultyName;
    private List<String> facultyNames;

    private String subjectName;
    private List<String> subjectNames;

    private List<CourseTrainingPlan> courseTrainingPlans;

    public CourseSearchBeana() {
    }

    public void subjectListener() {
        
    }
    
     public void setCourseTrainingPlans() {
        
    }

    /**
     * @return the facultyName
     */
    public String getFacultyName() {
        return facultyName;
    }

    /**
     * @param facultyName the facultyName to set
     */
    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    /**
     * @return the facultyNames
     */
    public List<String> getFacultyNames() {
        return facultyNames;
    }

    /**
     * @param facultyNames the facultyNames to set
     */
    public void setFacultyNames(List<String> facultyNames) {
        this.facultyNames = facultyNames;
    }

    /**
     * @return the subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * @return the subjectNames
     */
    public List<String> getSubjectNames() {
        return subjectNames;
    }

    /**
     * @param subjectNames the subjectNames to set
     */
    public void setSubjectNames(List<String> subjectNames) {
        this.subjectNames = subjectNames;
    }

    /**
     * @return the courseTrainingPlans
     */
    public List<CourseTrainingPlan> getCourseTrainingPlans() {
        return courseTrainingPlans;
    }

    /**
     * @param courseTrainingPlans the courseTrainingPlans to set
     */
   

}
