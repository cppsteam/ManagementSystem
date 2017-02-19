/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teachingProgram;

import dao.CourseDAO;
import dao.SubjectDAO;
import entites.CourseTrainingPlan;
import entites.Subject;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.*;

/**
 *
 * @author chenpeipei
 */
@ManagedBean
@ViewScoped
public class TeachingProgramSearchBean {

    private String subjectName;
    private List<String> subjectNames;

    private Subject subject;

    private List<CourseTrainingPlan> courseTrainingPlans;
    private List<CourseTrainingPlan> gbPlans = new ArrayList<CourseTrainingPlan>();
    private List<CourseTrainingPlan> gkPlans = new ArrayList<CourseTrainingPlan>();
    private List<CourseTrainingPlan> xbPlans = new ArrayList<CourseTrainingPlan>();
    private List<CourseTrainingPlan> xxPlans = new ArrayList<CourseTrainingPlan>();
    private List<CourseTrainingPlan> zbPlans = new ArrayList<CourseTrainingPlan>();
    private List<CourseTrainingPlan> zxPlans = new ArrayList<CourseTrainingPlan>();

    public TeachingProgramSearchBean() {
    }

    public void setCourseTrainingPlans() {
        setSubject(SubjectDAO.findSubjectByName(getSubjectName()));
        setCourseTrainingPlans((List<CourseTrainingPlan>) getSubject().getTrainingPlan().getCourseTrainingPlans());
        for (CourseTrainingPlan plan : getCourseTrainingPlans()) {
            if (plan.getCourse().getType().equals("公共基础课")) {
                switch (plan.getCourse().getProperty()) {
                    case "必修课":
                        gbPlans.add(plan);
                        break;
                    case "课外教育":
                        gkPlans.add(plan);
                        break;
                }
            } else if (plan.getCourse().getType().equals("学院基础课")) {
                switch (plan.getCourse().getProperty()) {
                    case "必修课":
                        xbPlans.add(plan);
                        break;
                    case "选修课":
                        xxPlans.add(plan);
                        break;
                }
            } else if (plan.getCourse().getType().equals("专业课")) {
                switch (plan.getCourse().getProperty()) {
                    case "必修课":
                        zbPlans.add(plan);
                        break;
                    case "选修课":
                        zxPlans.add(plan);
                        break;
                }
            }

        }
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
        subjectNames = SubjectDAO.findAllSubjectNames();
        return subjectNames;
    }

    /**
     * @param subjectNames the subjectNames to set
     */
    public void setSubjectNames(List<String> subjectNames) {
        this.subjectNames = subjectNames;
    }

    /**
     * @return the subject
     */
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
    public List<CourseTrainingPlan> getCourseTrainingPlans() {
        return courseTrainingPlans;
    }

    /**
     * @param courseTrainingPlans the courseTrainingPlans to set
     */
    public void setCourseTrainingPlans(List<CourseTrainingPlan> courseTrainingPlans) {
        this.courseTrainingPlans = courseTrainingPlans;
    }

    /**
     * @return the gbPlans
     */
    public List<CourseTrainingPlan> getGbPlans() {
        return gbPlans;
    }

    /**
     * @param gbPlans the gbPlans to set
     */
    public void setGbPlans(List<CourseTrainingPlan> gbPlans) {
        this.gbPlans = gbPlans;
    }

    /**
     * @return the gkPlans
     */
    public List<CourseTrainingPlan> getGkPlans() {
        return gkPlans;
    }

    /**
     * @param gkPlans the gkPlans to set
     */
    public void setGkPlans(List<CourseTrainingPlan> gkPlans) {
        this.gkPlans = gkPlans;
    }

    /**
     * @return the xbPlans
     */
    public List<CourseTrainingPlan> getXbPlans() {
        return xbPlans;
    }

    /**
     * @param xbPlans the xbPlans to set
     */
    public void setXbPlans(List<CourseTrainingPlan> xbPlans) {
        this.xbPlans = xbPlans;
    }

    /**
     * @return the xxPlans
     */
    public List<CourseTrainingPlan> getXxPlans() {
        return xxPlans;
    }

    /**
     * @param xxPlans the xxPlans to set
     */
    public void setXxPlans(List<CourseTrainingPlan> xxPlans) {
        this.xxPlans = xxPlans;
    }

    /**
     * @return the zbPlans
     */
    public List<CourseTrainingPlan> getZbPlans() {
        return zbPlans;
    }

    /**
     * @param zbPlans the zbPlans to set
     */
    public void setZbPlans(List<CourseTrainingPlan> zbPlans) {
        this.zbPlans = zbPlans;
    }

    /**
     * @return the zxPlans
     */
    public List<CourseTrainingPlan> getZxPlans() {
        return zxPlans;
    }

    /**
     * @param zxPlans the zxPlans to set
     */
    public void setZxPlans(List<CourseTrainingPlan> zxPlans) {
        this.zxPlans = zxPlans;
    }

}
