/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;


import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author 0576
 */



@Entity
@Table(name = "student")
@DiscriminatorValue("student")
@PrimaryKeyJoinColumn(name = "id")
public class Student extends User {

    @ManyToOne
    @JoinColumn(name = "classes_id")
    private Classes classes;

    @OneToMany(mappedBy = "student")
    private Collection<StdArrange> stdArranges = new ArrayList<StdArrange>();
    
    private String registerYear;

    public Student() {

    }

    public Classes getClasses() {
        return classes;
    }

    /**
     * @param classes the classes to set
     */
    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Collection<StdArrange> getStdArranges() {
        return stdArranges;
    }

    public void setStdArranges(Collection<StdArrange> stdArranges) {
        this.stdArranges = stdArranges;
    }

    /**
     * @return the registerYear
     */
    public String getRegisterYear() {
        return registerYear;
    }

    /**
     * @param registerYear the registerYear to set
     */
    public void setRegisterYear(String registerYear) {
        this.registerYear = registerYear;
    }


}
