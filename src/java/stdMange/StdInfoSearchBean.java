/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stdMange;

import dao.ClassesDAO;
import dao.StudentDAO;
import entites.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

/**
 *
 * @author chenpeipei
 */
@ManagedBean
@ViewScoped
public class StdInfoSearchBean implements Serializable {

    private String className;
    private List<String> classNames;

    private Classes classes;

    private String stdCode;
    private Student student = new Student();
    private List<String> students = new ArrayList<String>();

    public StdInfoSearchBean() {
    }

    public void setStudents() {
        getStudents().clear();
        setClasses(ClassesDAO.findClassesByName(getClassName()));
        for (Student s : getClasses().getStudents()) {
            getStudents().add(s.getCode());
        }
    }

    public void findStudent() {
        student = StudentDAO.findStudentByCode(stdCode);
    }

    public Student getStudent() {
        return student;
    }

    public void updateStudent() {
        StudentDAO.updateStudent(student);
        student=new Student();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "修改成功！"));
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
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

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * @return the students
     */
    public List<String> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(List<String> students) {
        this.students = students;
    }

    /**
     * @return the stdCode
     */
    public String getStdCode() {
        return stdCode;
    }

    /**
     * @param stdCode the stdCode to set
     */
    public void setStdCode(String stdCode) {
        this.stdCode = stdCode;
    }

}
