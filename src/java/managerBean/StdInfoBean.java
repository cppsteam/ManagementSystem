/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import dao.*;
import entites.*;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.*;



/**
 *
 * @author 0576
 */
@ManagedBean
@ViewScoped
public class StdInfoBean implements Serializable {

    private String className;
    private List<String> classNames;

    private Classes classes;

    private Student student = new Student();
    private List<Student> students;

    public StdInfoBean() {
    }

    public void setStudents() {
        classes = ClassesDAO.findAllClassesByName(className);
        students = (List) classes.getStudents();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent() {
        student.setClasses(classes);
        student.setPassword(student.getCode());
        student.setStatus("在校");
        student.setAddress("");
        student.setUserType("student");
        StudentDAO.addStudent(student);
    }

    public void modifyStudent() {
        //修改学生信息
    }

    public void deleteStudent() {
        //删除学生信息
    }

    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }


    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * @return the classes
     */
    public Classes getClasses() {
        return classes;
    }

    public String getClassName() {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @return the classNames
     */
    public List<String> getClassNames() {
        classNames = ClassesDAO.findAllClassesNames();
        return classNames;
    }

    /**
     * @param classNames the classNames to set
     */
    public void setClassNames(List<String> classNames) {
        this.classNames = classNames;
    }

}
