/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author 0576
 */
@Entity
@Table(name = "teacherArrange")
public class TeacherArrange implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "teacherArrange")
    @TableGenerator(name = "teacherArrange",
            table = "generator",
            pkColumnName = "generator_name",
            valueColumnName = "generator_value",
            pkColumnValue = "teacherArrange_id",
            allocationSize = 1)
    private int id;
    private String status;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToOne(mappedBy = "teacherArrange")
    private CourseArrange courseArrange;

    public TeacherArrange() {
    }

    public TeacherArrange(String status) {
        this.status = status;
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
     * @return the state
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param state the state to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the teacher
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * @param teacher the teacher to set
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * @return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * @return the courseArrange
     */
    public CourseArrange getCourseArrange() {
        return courseArrange;
    }

    /**
     * @param courseArrange the courseArrange to set
     */
    public void setCourseArrange(CourseArrange courseArrange) {
        this.courseArrange = courseArrange;
    }

}
