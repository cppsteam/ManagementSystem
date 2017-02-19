/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentBean;

import entites.*;
import java.util.*;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 0576
 */
@ManagedBean
@RequestScoped
public class ChooseCourseBean {

    private CourseArrange selectedArrange;
    private List<CourseArrange> courseArranges=new ArrayList<>();
    
    private User user;
    
    private String courseType;


    public ChooseCourseBean() {

    }
    
    public void chooseCourse() {
        //选课
    }

    public User getUser() {
        setUser();
        return user;
    }

    public void setUser() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        user = (User) session.getAttribute("user");
    }

    /**
     * @return the selectedArrange
     */
    public CourseArrange getSelectedArrange() {
        return selectedArrange;
    }

    /**
     * @param selectedArrange the selectedArrange to set
     */
    public void setSelectedArrange(CourseArrange selectedArrange) {
        this.selectedArrange = selectedArrange;
    }

    /**
     * @return the courseArranges
     */
    public List<CourseArrange> getCourseArranges() {
        //xie
        return courseArranges;
    }

    /**
     * @param courseArranges the courseArranges to set
     */
    public void setCourseArranges(List<CourseArrange> courseArranges) {
        this.courseArranges = courseArranges;
    }

    /**
     * @return the courseType
     */
    public String getCourseType() {
        return courseType;
    }

    /**
     * @param courseType the courseType to set
     */
    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }
}
