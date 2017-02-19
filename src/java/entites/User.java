package entites;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.Date;
import java.util.*;

import javax.persistence.*;

/**
 *
 * @author 0576
 */
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "userType", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "user")
    @TableGenerator(name = "user",
            table = "generator",
            pkColumnName = "generator_name",
            valueColumnName = "generator_value",
            pkColumnValue = "user_id",
            allocationSize = 1)
    private int id;

    private String code;
    private String name;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthday;

    private String sex;
    private String password;
    private String status;
    private String phone;
    
    private String userType;
    private String birthPlace;

    @ManyToMany
    @JoinTable(name = "role_user",
            joinColumns = {
                @JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Collection<Role> roles = new ArrayList<Role>();

    public User() {
    }

    public User(String code, String name, Date birthday, String sex,
            String password, String status, String phone,String userType) {
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.password = password;
        this.status = status;
        this.phone = phone;
       
        this.userType = userType;
    }

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
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the roles
     */
    public Collection<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

 

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @return the birthPlace
     */
    public String getBirthPlace() {
        return birthPlace;
    }

    /**
     * @param birthPlace the birthPlace to set
     */
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
