/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author 0576
 */

@Entity
@Table(name = "teacher")
@DiscriminatorValue("teacher")
@PrimaryKeyJoinColumn(name = "id")
public class Teacher extends User {

    private String title;
    private String diploma;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    
    @OneToMany(mappedBy = "teacher")
    private Collection<TeacherArrange> teacherArranges=new ArrayList<TeacherArrange>();

    public Teacher() {

    }

    public Teacher(String code, String name, Date birthday, String sex, String password, String state, String phone, String userType, String title, String diploma) {
        super(code, name, birthday, sex, password, state, phone,userType);
        this.title = title;
        this.diploma = diploma;
    }

    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the diploma
     */
    public String getDiploma() {
        return diploma;
    }

    /**
     * @param diploma the diploma to set
     */
    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * @return the teacherArranges
     */
    public Collection<TeacherArrange> getTeacherArranges() {
        return teacherArranges;
    }

    /**
     * @param teacherArranges the teacherArranges to set
     */
    public void setTeacherArranges(Collection<TeacherArrange> teacherArranges) {
        this.teacherArranges = teacherArranges;
    }

}
