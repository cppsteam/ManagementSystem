package entites;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author 0576
 */
@Entity
@Table(name = "childRespon")
public class ChildRespon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "childRespon")
    @TableGenerator(name = "childRespon",
            table = "generator",
            pkColumnName = "generator_name",
            valueColumnName = "generator_value",
            pkColumnValue = "childRespon_id",
            allocationSize = 1)
    private int id;

    private String name;
    private String url;
    private String icon;

    @ManyToOne
    @JoinColumn(name="respon_id")
    private Responsibility responsibility;

    
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
     * @return the responsibility
     */
    public Responsibility getResponsibility() {
        return responsibility;
    }

    /**
     * @param responsibility the responsibility to set
     */
    public void setResponsibility(Responsibility responsibility) {
        this.responsibility = responsibility;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

}
