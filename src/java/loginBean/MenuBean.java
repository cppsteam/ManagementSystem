/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginBean;

import entites.*;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.*;

/**
 *
 * @author 0576
 */
@ManagedBean
@ViewScoped
public class MenuBean implements Serializable{

    private MenuModel model;
    private String url;
    private String userName;

    public MenuBean() {
        model = new DefaultMenuModel();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        User user = (User) session.getAttribute("user");
        userName = user.getName();
        //
        List<Role> roles = (List) user.getRoles();
        List<Responsibility> reponses;
        List<ChildRespon> childRespons;
        //
        DefaultSubMenu subMenu;
        DefaultMenuItem menuItem;
        for (int i = 0; i < roles.size(); i++) {
            reponses = (List) roles.get(i).getResponsibilities();
            for (int k = 0; k < reponses.size(); k++) {
                subMenu = new DefaultSubMenu(reponses.get(k).getName());
                childRespons = (List) reponses.get(k).getChildRespons();
                for (int j = 0; j < childRespons.size(); j++) {
                    menuItem = new DefaultMenuItem(childRespons.get(j).getName());
                    menuItem.setParam("URL", childRespons.get(j).getUrl());
                    menuItem.setCommand("#{menuBean.menuListener}");
                    menuItem.setUpdate(":main");
                    //menuItem.setIcon(childRespons.get(j).getIcon());
                    //menuItem.setIcon("ui-icon-disk");
                    subMenu.addElement(menuItem);
                }
                model.addElement(subMenu);
            }

        }
    }

    public void menuListener(MenuActionEvent e) {
        MenuItem menuItem = e.getMenuItem();
        setUrl(menuItem.getParams().get("URL").get(0));
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
