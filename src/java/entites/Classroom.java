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
@Table(name = "classroom")
public class Classroom  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "classroom")
    @TableGenerator(name = "classroom",
            table = "generator",
            pkColumnName = "generator_name",
            valueColumnName = "generator_value",
            pkColumnValue = "classroom_id",
            allocationSize = 1)
    private int id;
    private String code;
    private int capacity;
    private String building;
    private String type;
    
    @OneToMany(mappedBy="classroom")
    private Collection<CourseArrange>courseArranges=new ArrayList<CourseArrange>();

    public Classroom() {

    }

    public Classroom(String code, int capacity, String building,String type) {
        this.code = code;
        this.capacity = capacity;
        this.building = building;
        this.type=type;
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

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the building
     */
    public String getBuilding() {
        return building;
    }

    /**
     * @param building the building to set
     */
    public void setBuilding(String building) {
        this.building = building;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the courseArrangements
     */
    public Collection<CourseArrange> getCourseArranges() {
        return courseArranges;
    }

    /**
     * @param courseArrangements the courseArrangements to set
     */
    public void setCourseArranges(Collection<CourseArrange> courseArranges) {
        this.courseArranges = courseArranges;
    }
}
