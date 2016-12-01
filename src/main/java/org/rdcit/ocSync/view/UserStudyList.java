/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rdcit.ocSync.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.rdcit.ocSync.model.Study;

/**
 *
 * @author sa841
 */
@ManagedBean(name = "UserStudyList")
@ViewScoped
public class UserStudyList implements Serializable{
    
   private List<Study> lStudy;
   public Study selectedStudy;
   
   @PostConstruct
   public void init(){
       lStudy = new ArrayList();
       Study s1 = new Study("study3");
       Study s2 = new Study("study2");
       Study s3 = new Study("study3");
       lStudy.add(s3);
       lStudy.add(s2);
       lStudy.add(s1);
       
   }

    public UserStudyList() {
    }

    public List<Study> getlStudy() {
        return lStudy;
    }

    public void setlStudy(List<Study> lStudy) {
        this.lStudy = lStudy;
    }

    public Study getSelectedStudy() {
        return selectedStudy;
    }

    public void setSelectedStudy(Study selectedStudy) {
        this.selectedStudy = selectedStudy;
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
    
   
    
}
