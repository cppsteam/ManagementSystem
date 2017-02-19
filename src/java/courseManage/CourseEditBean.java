/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseManage;

import dao.*;
import entites.*;
import java.io.Serializable;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author chenpeipei
 */
@ManagedBean
@ViewScoped
public class CourseEditBean implements Serializable {

    private List<CourseTrainingPlan> courseTrainingPlans;

    private List<Course> filteredCourses;

    private List<String> courseNames;

    private Course course = new Course();

    private CourseTrainingPlan courseTrainingPlan = new CourseTrainingPlan();

    private List<String> subjects = new ArrayList<String>();
    private String subject;
    
    private List<CourseTrainingPlan> selectedCourseTrainingPlans;

    public void addCourse() {
        Subject sub = SubjectDAO.findSubjectByName(getSubject());
        CourseDAO.addCourse(getCourse());
        getCourseTrainingPlan().setCourse(getCourse());
        getCourseTrainingPlan().setTrainingPlan(sub.getTrainingPlan());
        CourseTrainingPlanDAO.addCourseTrainingPlan(getCourseTrainingPlan());
        setCourse(new Course());
        setCourseTrainingPlan(new CourseTrainingPlan());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "添加成功！"));
    }
    public void deleteCourse() {
        for (CourseTrainingPlan cp : selectedCourseTrainingPlans) {
            CourseTrainingPlanDAO.deleteCourseTrainingPlan(courseTrainingPlan);
            CourseDAO.deleteCourse(course);
        }
        selectedCourseTrainingPlans.clear();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "删除成功！"));
    }

    public void updateCourse() {
        CourseDAO.updateCourse(getCourse());
        setCourse(new Course());
        CourseTrainingPlanDAO.updateCourseTrainingPlan(getCourseTrainingPlan());
        setCourseTrainingPlan(new CourseTrainingPlan());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "修改成功！"));
    }

    public List<CourseTrainingPlan> getCourseTrainingPlans() {
        courseTrainingPlans = CourseTrainingPlanDAO.findAllCourseTrainingPlans();
        return courseTrainingPlans;
    }
    public void onRowSelect(SelectEvent event) {
        courseTrainingPlan=(CourseTrainingPlan) event.getObject();
        course=courseTrainingPlan.getCourse();
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
        courseNames = CourseDAO.findAllCourseNames();
        return courseNames;
    }

    /**
     * @param courseNames the courseNames to set
     */
    public void setCourseNames(List<String> courseNames) {
        this.courseNames = courseNames;
    }

    /**
     * @return the course
     */
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
     * @return the courseTrainingPlan
     */
    public CourseTrainingPlan getCourseTrainingPlan() {
        return courseTrainingPlan;
    }

    /**
     * @param courseTrainingPlan the courseTrainingPlan to set
     */
    public void setCourseTrainingPlan(CourseTrainingPlan courseTrainingPlan) {
        this.courseTrainingPlan = courseTrainingPlan;
    }

    /**
     * @return the subjects
     */
    public List<String> getSubjects() {
        subjects = SubjectDAO.findAllSubjectNames();
        return subjects;
    }

    /**
     * @param subjects the subjects to set
     */
    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the selectedCourseTrainingPlans
     */
    public List<CourseTrainingPlan> getSelectedCourseTrainingPlans() {
        return selectedCourseTrainingPlans;
    }

    /**
     * @param selectedCourseTrainingPlans the selectedCourseTrainingPlans to set
     */
    public void setSelectedCourseTrainingPlans(List<CourseTrainingPlan> selectedCourseTrainingPlans) {
        this.selectedCourseTrainingPlans = selectedCourseTrainingPlans;
    }

}
