/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stdMange;

import dao.*;
import entites.*;
import java.io.Serializable;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.*;

/**
 *
 * @author chenpeipei
 */
@ManagedBean
@ViewScoped
public class StdInfoEditBean implements Serializable {

    private String className;
    private List<String> classNames;

    private Classes classes;

    private Student student = new Student();
    private List<Student> students;

    private List<Student> selectedStudents;

    private String province;
    private List<String> provinces;

    private String city;
    private List<String> cities=new ArrayList<String>();

    private String region;
    private List<String> regions=new ArrayList<String>();

    public void setStudents() {
        setClasses(ClassesDAO.findClassesByName(getClassName()));
        setStudents((List<Student>) (List) getClasses().getStudents());
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent() {
        getStudent().setClasses(getClasses());
        getStudent().setPassword(getStudent().getCode());
        getStudent().setStatus("在校");
        student.setBirthPlace(province + city + region);
        StudentDAO.addStudent(student);
        getStudents().add(getStudent());
        student=new Student();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "添加成功！"));
    }
    public void updateStudent(){
        StudentDAO.updateStudent(student);
        student=new Student();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "修改成功！"));
    }

    public void deleteStudent() {
        for (Student std : getSelectedStudents()) {
            StudentDAO.deleteStudent(std);
            getStudents().remove(std);
        }
        selectedStudents.clear();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "删除成功！"));
    }

    public void cityListener() {
        Province pro = ProvinceDAO.findProvinceByName(province);
        if (!cities.isEmpty()) {
            cities.clear();
        }
        for (City c : pro.getCities()) {
            cities.add(c.getName());
        }
    }

    public void regionListener() {
        City c = CityDAO.findCityByName(city);
        if (!regions.isEmpty()) {
            regions.clear();
        }
        for (Region r : c.getRegions()) {
            regions.add(r.getName());
        }
    }
    
    public void onRowSelect(SelectEvent event) {
        student=(Student) event.getObject();
    }

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

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * @return the selectedStudents
     */
    public List<Student> getSelectedStudents() {
        return selectedStudents;
    }

    /**
     * @param selectedStudents the selectedStudents to set
     */
    public void setSelectedStudents(List<Student> selectedStudents) {
        this.selectedStudents = selectedStudents;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the provinces
     */
    public List<String> getProvinces() {
        provinces = ProvinceDAO.findAllProvinceNames();
        return provinces;
    }

    /**
     * @param provinces the provinces to set
     */
    public void setProvinces(List<String> provinces) {
        this.provinces = provinces;
    }

    /**
     * @return the cities
     */
    public List<String> getCities() {
        return cities;
    }

    /**
     * @param cities the cities to set
     */
    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the regions
     */
    public List<String> getRegions() {
        return regions;
    }

    /**
     * @param regions the regions to set
     */
    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

}
