/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherBean;

import dao.CourseArrangeDAO;
import entites.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TableColumn.CellEditEvent;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 0576
 */
@ManagedBean
@RequestScoped
public class ScoreInputBean {

    private String classCode;
    private List<String> classCodes;

    private List<StdArrange> stdArranges;

    public ScoreInputBean() {
    }

    public void saveScore() {

    }

    public void calculateTotalScore() {

    }

    public void onCellEdit(CellEditEvent event) {

    }

    public void setStdArranges() {
        CourseArrange courseArrange = CourseArrangeDAO.findCourseArrangesByClassCode(classCode);
        stdArranges = (List<StdArrange>) (List) courseArrange.getStdArranges();
    }

    public String getClassCode() {
        setClassCode();
        return classCode;
    }

    public void setClassCode() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Teacher teacher = (Teacher) session.getAttribute("user");
        List<TeacherArrange> teacherArrange = (List) teacher.getTeacherArranges();
        classCodes = new ArrayList<>();
        for (int i = 0; i < teacherArrange.size(); i++) {
            classCodes.add(teacherArrange.get(i).getCourseArrange().getClassCode());
        }
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
     * @return the stdArranges
     */
    public List<StdArrange> getStdArranges() {
        return stdArranges;
    }

}
