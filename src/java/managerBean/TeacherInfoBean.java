/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;


import dao.*;
import entites.*;
import java.util.*;
import javax.faces.bean.*;


/**
 *
 * @author 0576
 */
@ManagedBean
@RequestScoped
public class TeacherInfoBean {

    private Teacher teacher;
    private List<Teacher> teachers;

    private String subjectName;
    private List<String> subjectNames;

    private Subject subject;

    public TeacherInfoBean() {
    }

    public void setTeachers() {
        subject = SubjectDAO.findSubjectByName(subjectName);
        teachers=(List<Teacher>) (List) subject.getTeachers();
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher() {
        //增加老师信息
    }

    public void modifyTeacher() {
        //修改老师信息
    }

    public void deleteTeacher() {
        //删除老师信息
    }

    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * @param teacher the teacher to set
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.setTeachers(teachers);
    }

    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
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

}
