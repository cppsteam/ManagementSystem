/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherManage;

import dao.CityDAO;
import dao.ProvinceDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TeacherDAO;
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
public class TeacherInfoEditBean implements Serializable{

    private Teacher teacher=new Teacher();
    private List<Teacher> teachers;

    private String subjectName;
    private List<String> subjectNames;

    private Subject subject;
    
    private String province;
    private List<String> provinces;

    private String city;
    private List<String> cities=new ArrayList<String>();

    private String region;
    private List<String> regions=new ArrayList<String>();
    
    private List<Teacher> selectedTeachers;

    public TeacherInfoEditBean() {
    }

    public void setTeachers() {
        setSubject(SubjectDAO.findSubjectByName(getSubjectName()));
        setTeachers((List<Teacher>) (List) getSubject().getTeachers());
    }
    
    public void cityListener() {
        Province pro = ProvinceDAO.findProvinceByName(getProvince());
        if (!cities.isEmpty()) {
            getCities().clear();
        }
        for (City c : pro.getCities()) {
            getCities().add(c.getName());
        }
    }

    public void regionListener() {
        City c = CityDAO.findCityByName(getCity());
        if (!regions.isEmpty()) {
            getRegions().clear();
        }
        for (Region r : c.getRegions()) {
            getRegions().add(r.getName());
        }
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }
    

    public void addTeacher() {
        getTeacher().setSubject(getSubject());
        getTeacher().setPassword(getTeacher().getCode());
        getTeacher().setStatus("在职");
        getTeacher().setBirthPlace(getProvince()+getCity()+getRegion());
        TeacherDAO.addTeacher(getTeacher());
        getTeachers().add(getTeacher());
        setTeacher(new Teacher());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "添加成功！"));
    }

    public void updateTeacher() {
        TeacherDAO.updateTeacher(getTeacher());
        setTeacher(new Teacher());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "修改成功！"));
    }
    
    public void deleteTeacher(){
        for (Teacher tea : getTeachers()) {
            TeacherDAO.deleteTeacher(tea);
            getTeachers().remove(tea);
        }
        getSelectedTeachers().clear();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "删除成功！"));
    
    }
    public void onRowSelect(SelectEvent event) {
        teacher=(Teacher) event.getObject();
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

    /**
     * @return the selectedTeachers
     */
    public List<Teacher> getSelectedTeachers() {
        return selectedTeachers;
    }

    /**
     * @param selectedTeachers the selectedTeachers to set
     */
    public void setSelectedTeachers(List<Teacher> selectedTeachers) {
        this.selectedTeachers = selectedTeachers;
    }

}
