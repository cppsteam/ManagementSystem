/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import dao.*;
import entites.*;
import java.util.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javax.faces.bean.*;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author 0576
 */
@ManagedBean
@SessionScoped
public class ScoreManageBean {

    private String teacherName;
    private List<String> teacherNames;

    private Teacher teacher;

    private String classCode;
    private List<String> classCodes;

    private List<CourseArrange> courseArranges;

    private List<StdArrange> stdArranges;

    public ScoreManageBean() {
    }

    public void setStdArranges() {
        CourseArrange courseArrange = CourseArrangeDAO.findCourseArrangesByClassCode(classCode);
        stdArranges = (List<StdArrange>) (List) courseArrange.getStdArranges();
    }

    public void onRowEdit(RowEditEvent event) {
        StdArrange stdArrange = (StdArrange) event.getObject();
        StdArrangeDAO.updateStdArrange(stdArrange);
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void classCodesListener() {
        teacher = TeacherDAO.findTeacherByName(getTeacherName());
        List<TeacherArrange> teacherArrange = (List) getTeacher().getTeacherArranges();
        classCodes = new ArrayList<>();
        for (int i = 0; i < teacherArrange.size(); i++) {
            classCodes.add(teacherArrange.get(i).getCourseArrange().getClassCode());
        }
    }

    /**
     * @return the courseArranges
     */
    public List<CourseArrange> getCourseArranges() {
        return courseArranges;
    }

    /**
     * @param courseArranges the courseArranges to set
     */
    public void setCourseArranges(List<CourseArrange> courseArranges) {
        this.courseArranges = courseArranges;
    }

    /**
     * @return the stdArranges
     */
    public List<StdArrange> getStdArranges() {
        return stdArranges;
    }

    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @param teacherName the teacherName to set
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * @return the teacherNames
     */
    public List<String> getTeacherNames() {
        teacherNames = TeacherDAO.findAllTeacherNames();
        return teacherNames;
    }

    /**
     * @param teacherNames the teacherNames to set
     */
    public void setTeacherNames(List<String> teacherNames) {
        this.teacherNames = teacherNames;
    }

    /**
     * @return the teacher
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * @return the classCodes
     */
    public List<String> getClassCodes() {
        return classCodes;
    }

    /**
     * @param classCodes the classCodes to set
     */
    public void setClassCodes(List<String> classCodes) {
        this.classCodes = classCodes;
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
     * @param stdArranges the stdArranges to set
     */
    public void setStdArranges(List<StdArrange> stdArranges) {
        this.stdArranges = stdArranges;
    }

    /**
     * @param stdArranges the stdArranges to set
     */
}
