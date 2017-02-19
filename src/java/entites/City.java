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
@Table(name = "city")
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "city")
    @TableGenerator(name = "city",
            table = "generator",
            pkColumnName = "generator_name",
            valueColumnName = "generator_value",
            pkColumnValue = "city_id",
            allocationSize = 1)
    private int id;

    @Column(name="city_id")
    private String cityId;
    
    private String name;

    @ManyToOne
    @JoinColumn(name = "province_id",referencedColumnName="province_id")
    private Province province;
    
    @OneToMany(mappedBy = "city")
    private Collection<Region> regions = new ArrayList<Region>(); 

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
     * @return the province
     */
    public Province getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(Province province) {
        this.province = province;
    }

    /**
     * @return the regions
     */
    public Collection<Region> getRegions() {
        return regions;
    }

    /**
     * @param regions the regions to set
     */
    public void setRegions(Collection<Region> regions) {
        this.regions = regions;
    }

    /**
     * @return the cityId
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * @param cityId the cityId to set
     */
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

}
