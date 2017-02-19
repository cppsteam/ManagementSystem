/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author 0576
 */

@Entity
@Table(name = "classes")
public class Classes  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "classes")
    @TableGenerator(name = "classes",
            table = "generator",
            pkColumnName = "generator_name",
            valueColumnName = "generator_value",
            pkColumnValue = "classes_id",
            allocationSize = 1)
    private int id;
    private String code;
    private String name;

    private int studentNumber;
    private String rank;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "classes")
    private Collection<Student> students = new ArrayList<Student>();

    public Classes() {

    }

    public Classes(String code,String name, int studentNumber, String rank) {
        this.code=code;
        this.name = name;
        this.studentNumber = studentNumber;
        this.rank = rank;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the studentNumber
     */
    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     * @param studentNumber the studentNumber to set
     */
    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * @return the rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
}
