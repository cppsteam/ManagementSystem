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
 * @author chenpeipei
 */
@Entity
@Table(name = "province")
public class Province implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "province")
    @TableGenerator(name = "province",
            table = "generator",
            pkColumnName = "generator_name",
            valueColumnName = "generator_value",
            pkColumnValue = "province_id",
            allocationSize = 1)
    private int id;

    private String name;
    
    @Column(name="province_id")
    private String provinceId;
    
    @OneToMany(mappedBy = "province")
    private Collection<City> cities = new ArrayList<City>(); 

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
     * @return the cities
     */
    public Collection<City> getCities() {
        return cities;
    }

    /**
     * @param cities the cities to set
     */
    public void setCities(Collection<City> cities) {
        this.cities = cities;
    }

    /**
     * @return the provinceId
     */
    public String getProvinceId() {
        return provinceId;
    }

    /**
     * @param provinceId the provinceId to set
     */
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

}
