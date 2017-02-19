/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentBean;

import entites.StdArrange;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author 0576
 */
@ManagedBean
@RequestScoped
public class ScoreSearchBean {

    private String semester;
    private ArrayList<String> semesters;

    private List<StdArrange> stdArranges;

    public ScoreSearchBean() {
    }

   
    public void setStdArranges() {
        //根据学期以及该生的课程选择得到课程安排
    }
    
    public String getSemester() {
        //得到学期
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * @return the semesters
     */
    public ArrayList<String> getSemesters() {
        return semesters;
    }

    /**
     * @param semesters the semesters to set
     */
    public void setSemesters(ArrayList<String> semesters) {
        this.semesters = semesters;
    }

    /**
     * @return the stdArranges
     */
    public List<StdArrange> getStdArranges() {
        return stdArranges;
    }

    /**
     * @param stdArranges the stdArranges to set
     */
    

}
