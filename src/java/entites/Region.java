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
 * @author chenpeipei
 */
@Entity
@Table(name="region")
public class Region implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "region")
    @TableGenerator(name = "region",
            table = "generator",
            pkColumnName = "generator_name",
            valueColumnName = "generator_value",
            pkColumnValue = "region_id",
            allocationSize = 1)
    private int id;

    private String name;
    
    @Column(name="region_id")
    private String regionId;
    
    @ManyToOne
    @JoinColumn(name="city_id",referencedColumnName="city_id")
    private City city;

    public int getId() {
        return id;
    }

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
     * @return the city
     */
    public City getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * @return the regionId
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * @param regionId the regionId to set
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }
    
}
