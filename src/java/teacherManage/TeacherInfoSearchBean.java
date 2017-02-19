/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherManage;

import dao.*;
import entites.Subject;
import entites.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

/**
 *
 * @author chenpeipei
 */
@ManagedBean
@ViewScoped
public class TeacherInfoSearchBean implements Serializable{

    private String teacherCode;

    private Teacher teacher = new Teacher();
    private List<String> teachers = new ArrayList<String>();
    ;

    private String subjectName;
    private List<String> subjectNames;

    private Subject subject;

    public TeacherInfoSearchBean() {
    }

    public void setTeachers() {
        getTeachers().clear();
        setSubject(SubjectDAO.findSubjectByName(getSubjectName()));
        for (Teacher t : getSubject().getTeachers()) {
            getTeachers().add(t.getCode());
        }
    }

    public void findTeacher() {
        setTeacher(TeacherDAO.findTeacherByCode(getTeacherCode()));
    }


    public void updateTeacher() {
        TeacherDAO.updateTeacher(getTeacher());
        teacher=new Teacher();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "修改成功！"));
    
    }


    /**
     * @return the teacher
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * @param teacher the teacher to set
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * @return the teachers
     */
    public List<String> getTeachers() {
        return teachers;
    }

    /**
     * @param teachers the teachers to set
     */
    public void setTeachers(List<String> teachers) {
        this.teachers = teachers;
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
     * @return the teacherCode
     */
    public String getTeacherCode() {
        return teacherCode;
    }

    /**
     * @param teacherCode the teacherCode to set
     */
    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

}
