/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseManage;

import dao.CourseDAO;
import dao.CourseTrainingPlanDAO;
import entites.*;
import java.io.Serializable;
import java.util.*;
import javax.faces.bean.*;

/**
 *
 * @author chenpeipei
 */
@ManagedBean
@ViewScoped
public class CourseSearchBean implements Serializable {

    private List<CourseTrainingPlan> courseTrainingPlans;

    private List<Course> filteredCourses;
    
     private List<String> courseNames;
    

    public CourseSearchBean() {
    }

    public void findCourse() {

    }

    public List<CourseTrainingPlan> getCourseTrainingPlans() {
        courseTrainingPlans = CourseTrainingPlanDAO.findAllCourseTrainingPlans();
        return courseTrainingPlans;
    }

    /**
     * @param courseTrainingPlans the courseTrainingPlans to set
     */
    public void setCourseTrainingPlans(List<CourseTrainingPlan> courseTrainingPlans) {
        this.courseTrainingPlans = courseTrainingPlans;
    }

    /**
     * @return the filteredCourses
     */
    public List<Course> getFilteredCourses() {
        return filteredCourses;
    }

    /**
     * @param filteredCourses the filteredCourses to set
     */
    public void setFilteredCourses(List<Course> filteredCourses) {
        this.filteredCourses = filteredCourses;
    }

    /**
     * @return the courseNames
     */
    public List<String> getCourseNames() {
        courseNames=CourseDAO.findAllCourseNames();
        return courseNames;
    }

    /**
     * @param courseNames the courseNames to set
     */
    public void setCourseNames(List<String> courseNames) {
        this.courseNames = courseNames;
    }

}