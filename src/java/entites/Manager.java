/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Date;

import javax.persistence.*;

/**
 *
 * @author 0576
 */
@Entity
@Table(name = "manager")
@DiscriminatorValue("manager")
@PrimaryKeyJoinColumn(name = "id")
public class Manager extends User {

    public Manager() {

    }

    public Manager(String code, String name, Date birthday, String sex,
            String password, String title, String state, String phone,
            String userType) {
        super(code, name, birthday, sex, password, state, phone,
                userType);
    }

}
